package com.example.maytinhbotui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnumber1,btnumber2,btnumber3,btnumber4,btnumber5,btnumber6,btnumber7,btnumber8,btnumber9,btnumber0;
    Button btcong,bttru,btnhan,btchia,btC,btAC,btbang,btdaucham;
    TextView txtBieuthuc,txtKetqua,txtNumber;

    int congthuc;
    float result,result1,result2;
    String number;
    DecimalFormat format = new DecimalFormat("###.####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        // set sự kiện cho các buttun, thông qua hàm
        SetEventClick();
    }

    private void Anhxa(){
        txtNumber = (TextView) findViewById(R.id.txtmanhinh);
        txtKetqua = (TextView) findViewById(R.id.txtketqua);
        txtBieuthuc = (TextView) findViewById(R.id.txtbieuthuc);

        btnumber1 = (Button) findViewById(R.id.btnumber1);
        btnumber2 = (Button) findViewById(R.id.btnumber2);
        btnumber3 = (Button) findViewById(R.id.btnumber3);
        btnumber4 = (Button) findViewById(R.id.btnumber4);
        btnumber5 = (Button) findViewById(R.id.btnumber5);
        btnumber6 = (Button) findViewById(R.id.btnumber6);
        btnumber7 = (Button) findViewById(R.id.btnumber7);
        btnumber8 = (Button) findViewById(R.id.btnumber8);
        btnumber9 = (Button) findViewById(R.id.btnumber9);
        btnumber0 = (Button) findViewById(R.id.btnumber0);


        btcong = (Button) findViewById(R.id.btcong);
        bttru = (Button) findViewById(R.id.bttru);
        btnhan = (Button) findViewById(R.id.btnhan);
        btchia = (Button) findViewById(R.id.btchia);

        btdaucham = (Button) findViewById(R.id.btdaucham);
        btC = (Button) findViewById(R.id.btClear);
        btAC = (Button) findViewById(R.id.btCLearAll);
        btbang = (Button) findViewById(R.id.btbang);
    }

    private void SetEventClick(){
        btnumber0.setOnClickListener(this);
        btnumber1.setOnClickListener(this);
        btnumber2.setOnClickListener(this);
        btnumber3.setOnClickListener(this);
        btnumber4.setOnClickListener(this);
        btnumber5.setOnClickListener(this);
        btnumber6.setOnClickListener(this);
        btnumber7.setOnClickListener(this);
        btnumber8.setOnClickListener(this);
        btnumber9.setOnClickListener(this);

        btdaucham.setOnClickListener(this);
        btC.setOnClickListener(this);
        btAC.setOnClickListener(this);
        btbang.setOnClickListener(this);

        btcong.setOnClickListener(this);
        bttru.setOnClickListener(this);
        btnhan.setOnClickListener(this);
        btchia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnumber0:
                txtNumber.append("0");
                break;
            case R.id.btnumber1:
                txtNumber.append("1");
                break;
            case R.id.btnumber2:
                txtNumber.append("2");
                break;
            case R.id.btnumber3:
                txtNumber.append("3");
                break;
            case R.id.btnumber4:
                txtNumber.append("4");
                break;
            case R.id.btnumber5:
                txtNumber.append("5");
                break;
            case R.id.btnumber6:
                txtNumber.append("6");
                break;
            case R.id.btnumber7:
                txtNumber.append("7");
                break;
            case R.id.btnumber8:
                txtNumber.append("8");
                break;
            case R.id.btnumber9:
                txtNumber.append("9");
                break;
            case R.id.btdaucham:
                txtNumber.append(".");
                break;

            case R.id.btClear:
                number = txtNumber.getText().toString();
                if ( ! number.equals("") ){
                    String temp = number.substring(0,number.length()-1);
                    txtNumber.setText(temp);
                }
                break;
            case R.id.btCLearAll:
                txtNumber.setText("");
                txtBieuthuc.setText("");
                txtKetqua.setText("");
                result=0;
                break;

            case R.id.btnhan:
                number = txtNumber.getText().toString();
                if ( ! number.equals("") ){
                    result1 = Float.parseFloat(number);
                    txtNumber.setText("");
                    txtBieuthuc.setText(String.valueOf(format.format(result1)));
                    txtBieuthuc.append(" x ");
                    congthuc = 3;
                }
                break;
            case R.id.btchia:
                number = txtNumber.getText().toString();
                if ( ! number.equals("") ){
                    result1 = Float.parseFloat(number);
                    txtNumber.setText("");
                    txtBieuthuc.setText(String.valueOf(format.format(result1)));
                    txtBieuthuc.append(" / ");
                    congthuc = 4;
                }
                break;
            case R.id.btcong:
                number = txtNumber.getText().toString();
                if ( ! number.equals("") ) {
                    if (number.equals("-")){
                        txtNumber.setText("-");
                    }else if (number.equals("+")) {
                        txtNumber.setText("+");
                    }else {
                        result1 = Float.parseFloat(number);
                        txtNumber.setText("");
                        txtBieuthuc.setText(String.valueOf(format.format(result1)));
                        txtBieuthuc.append(" + ");
                        congthuc = 1;
                    }
                }else{
                    txtNumber.setText("+");
                }
                break;
            case R.id.bttru:
                number = txtNumber.getText().toString();
                if ( ! number.equals("") ){
                    if (number.equals("-")){
                        txtNumber.setText("+");
                    }else if (number.equals("+")) {
                        txtNumber.setText("-");
                    }else {
                        result1 = Float.parseFloat(number);
                        txtNumber.setText("");
                        txtBieuthuc.setText(String.valueOf(format.format(result1)));
                        txtBieuthuc.append(" - ");
                        congthuc = 2;
                    }
                }else{
                    txtNumber.setText("-");
                }
                break;
            case R.id.btbang:
                number = txtNumber.getText().toString();
                if ( ! number.equals("") ){
                    result2 = Float.parseFloat(number);
                    txtBieuthuc.append(String.valueOf(format.format(result2)));
                    txtBieuthuc.append(" = ");
                    switch (congthuc){
                        case 1:
                            result=result1+result2;
                            break;
                        case 2:
                            result=result1-result2;
                            break;
                        case 3:
                            result=result1*result2;
                            break;
                        case 4:
                            result=(float) result1/result2;
                            break;
                    }
                    txtKetqua.setText(String.valueOf(format.format(result)));
                    result1 = Float.parseFloat(txtKetqua.getText().toString());
                    txtNumber.setText(String.valueOf(format.format(result1)));
                }
                break;
        }
    }
}
