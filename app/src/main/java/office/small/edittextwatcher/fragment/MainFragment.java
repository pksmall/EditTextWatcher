package office.small.edittextwatcher.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.jakewharton.rxbinding.widget.RxTextView;
import butterknife.BindView;
import office.small.edittextwatcher.R;

public class MainFragment extends BaseFragment {
    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.etTextListener)
    EditText editText;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRxListener();
    }

    //-------------------Main logic here-------------------//
    private void setupRxListener() {
        RxTextView.textChanges(editText).subscribe(text -> {
            textView.setText(text);
        });
    }
}