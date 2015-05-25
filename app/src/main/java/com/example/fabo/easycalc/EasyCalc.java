package com.example.fabo.easycalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class EasyCalc extends Activity {

    public String strResult;
    public String strTemp;

    private char op;
    private funciones fn = new funciones();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_calc);

        strResult = "";
        strTemp = "";

        //Botones de numeros
        Button btn0 = (Button)findViewById(R.id.button0);
        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);
        Button btn5 = (Button)findViewById(R.id.button5);
        Button btn6 = (Button)findViewById(R.id.button6);
        Button btn7 = (Button)findViewById(R.id.button7);
        Button btn8 = (Button)findViewById(R.id.button8);
        Button btn9 = (Button)findViewById(R.id.button9);

        //Botones de funciones
        Button btnMas = (Button)findViewById(R.id.buttonMas);
        Button btnPor = (Button)findViewById(R.id.buttonPor);
        Button btnMenos = (Button)findViewById(R.id.buttonMenos);
        Button btnDivide = (Button)findViewById(R.id.buttonDiv);
        Button btnPunto = (Button)findViewById(R.id.buttonPunto);
        Button btnIgual = (Button)findViewById(R.id.buttonIgual);
        Button btnCE = (Button)findViewById(R.id.buttonCE);

        //TextView donde se muestra el resultado
        final TextView textResult = (TextView)findViewById(R.id.textResult);

        //Listeners botones de numeros
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strResult += '0';
                strTemp += '0';
                textResult.setText(strResult);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strResult += '1';
                strTemp += '1';
                textResult.setText(strResult);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strResult += '2';
                strTemp += '2';
                textResult.setText(strResult);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strResult += '3';
                strTemp += '3';
                textResult.setText(strResult);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strResult += '4';
                strTemp += '4';
                textResult.setText(strResult);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strResult += '5';
                strTemp += '5';
                textResult.setText(strResult);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strResult += '6';
                strTemp += '6';
                textResult.setText(strResult);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strResult += '7';
                strTemp += '7';
                textResult.setText(strResult);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strResult += '8';
                strTemp += '8';
                textResult.setText(strResult);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strResult += '9';
                strTemp += '9';
                textResult.setText(strResult);
            }
        });

        //Listeners botones de funciones
        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = '+';
                fn.setS1(strTemp);
                strTemp = "";
                strResult += '+';
                textResult.setText(strResult);
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = '-';
                fn.setS1(strTemp);
                strTemp = "";
                strResult += '-';
                textResult.setText(strResult);

            }
        });

        btnPor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = '*';
                fn.setS1(strTemp);
                strTemp = "";
                strResult += 'x';
                textResult.setText(strResult);

            }
        });

        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strTemp.isEmpty()){
                    strTemp += "0.";
                    strResult += "0.";
                }else {
                    strTemp += '.';
                    strResult += '.';
                }
                textResult.setText(strResult);

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = '/';
                fn.setS1(strTemp);
                strTemp = "";
                strResult += "÷";
                textResult.setText(strResult);
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn.setS2(strTemp);
                switch (op){
                    case '*':
                        strResult = fn.multi();
                        break;
                    case '/':
                        strResult = fn.division();
                        break;
                    case '+':
                        strResult = fn.suma();
                        break;
                    case '-':
                        strResult = fn.resta();
                        break;
                }
                textResult.setText(strResult);
                strTemp = strResult;
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {   //borra el ultimo caracter
            @Override
            public void onClick(View v) {
                if(!strResult.isEmpty()) {  //se asegura que haya algo en el string
                    strResult = strResult.substring(0, strResult.length() - 1);
                    strTemp = strTemp.substring(0, strTemp.length() - 1);
                    textResult.setText(strResult);
                }
            }
        });

        btnCE.setOnLongClickListener(new View.OnLongClickListener() {   //borra todo
            @Override
            public boolean onLongClick(View v) {
                strResult = "";
                strTemp = "";
                textResult.setText(strResult);
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_easy_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
