package br.com.alura.estoque.retrofit.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class CallBackSemRetorno implements Callback<Void> {

    private final RespostaCallBack callBack;

    public CallBackSemRetorno(RespostaCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    @EverythingIsNonNull
    public void onResponse(Call<Void> call, Response<Void> response) {
        if(response.isSuccessful()){
            callBack.quandoSucesso();
        }else {
            callBack.quandoFalha("Resposta não sucedida");
        }
    }

    @Override
    @EverythingIsNonNull
    public void onFailure(Call<Void> call, Throwable t) {
        callBack.quandoFalha("Falha de comunicação" + t.getMessage());
    }

    public interface RespostaCallBack{
        void quandoSucesso();
        void quandoFalha(String erro);
    }
}
