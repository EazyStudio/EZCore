package vn.eazy.studio.core.example;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import vn.eazy.studio.core.example.widgets.BookerlyButton;
import vn.eazy.studio.core.state_view.MultiStateView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BookerlyButton btStateView;
    private MultiStateView lyMultiState;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStateView = (BookerlyButton) findViewById(R.id.btStateView);
        lyMultiState = (MultiStateView) findViewById(R.id.lyMultiState);

        View errorView = lyMultiState.getView(MultiStateView.VIEW_STATE_ERROR);
        Button btRetry = (Button) errorView.findViewById(R.id.retry);
        btRetry.setOnClickListener(this);

        btStateView.setOnClickListener(this);

        handler = new Handler();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btStateView) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    lyMultiState.setViewState(MultiStateView.VIEW_STATE_LOADING);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            lyMultiState.setViewState(MultiStateView.VIEW_STATE_ERROR);
                        }
                    }, 2000);
                }
            }, 500);
        }else{
            Toast.makeText(getApplicationContext(),"Retry",Toast.LENGTH_SHORT).show();
        }
    }
}
