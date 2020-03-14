package cl.figonzal.evaluatool.interfaces;

import android.app.Activity;

public interface AbrirActivity {
    @SuppressWarnings("unused")
    void abrirActividad(Activity activity, Class<?> calledActivity, String log_title, String log_reponse);
}
