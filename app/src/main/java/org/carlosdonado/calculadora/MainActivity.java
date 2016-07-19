package org.carlosdonado.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlException;
import org.apache.commons.jexl3.MapContext;

public class MainActivity extends AppCompatActivity {
    //Definición de las propiedades


    private Button btnC;
    private Button btnDiv;
    private Button btnMul;
    private Button btnBack;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btnZero;
    private Button btnPoint;
    private Button btnMM;
    private Button btnResult;
    private Button btnAdd;
    private Button btnSub;
    private Button btnPer;

    private TextView historial;
    private TextView resultado;

    private String expresion;
    private String strResultado;
    private String strNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historial = (TextView) findViewById(R.id.historial);

        resultado = (TextView) findViewById(R.id.resultado);

        btnC = (Button) findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnC.getText().toString());
            }

        });

        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnDiv.getText().toString());
            }

        });

        btnMul = (Button) findViewById(R.id.btnMul);
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnMul.getText().toString());
            }

        });
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnBack.getText().toString());
            }

        });
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btn7.getText().toString());
            }

        });

        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btn8.getText().toString());
            }

        });

        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btn9.getText().toString());
            }

        });
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btn4.getText().toString());
            }

        });
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btn5.getText().toString());
            }

        });
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btn6.getText().toString());
            }

        });
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btn1.getText().toString());
            }

        });
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btn2.getText().toString());
            }

        });
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btn3.getText().toString());
            }

        });
        btnZero = (Button) findViewById(R.id.btnZero);
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnZero.getText().toString());
            }

        });
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnPoint.getText().toString());
            }

        });
        btnMM = (Button) findViewById(R.id.btnMM);
        btnMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnMM.getText().toString());
            }

        });
        btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnResult.getText().toString());
            }

        });
        btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnSub.getText().toString());
            }

        });
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnAdd.getText().toString());
            }

        });
        btnPer = (Button) findViewById(R.id.btnPer);
        strNum = "";
        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(btnPer.getText().toString());
            }

        });

        expresion = "";
        jexl = new JexlBuilder().create();
        context = new MapContext();
    }

    private JexlEngine jexl;
    private JexlContext context;

    private void buttonClick(String text) {
        if (!(text.equals("C") || text.equals("⌫")  || text.equals("="))) {
            try {
                if (text.equals("%") || text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")) {
                    if (text.equals(expresion.substring(expresion.length() - 1))) {

                    } else {
                        expresion = expresion + text;
                    }
                } else {
                    expresion = expresion + text;
                }

            } catch (IndexOutOfBoundsException ex ) {

            }
        }

        if (text.equals("⌫")) {
            try {
                expresion = expresion.substring(0, expresion.length() - 1);
            } catch (IndexOutOfBoundsException ex) {

            }
        }

        historial.setText(expresion);

        if (text.equals("=")) {
            try {
                if (!expresion.equals("")) {
                    org.apache.commons.jexl3.JexlExpression e = jexl.createExpression(expresion);
                    Number result = (Number) e.evaluate(context);
                    strResultado = result.toString();
                    resultado.setText(strResultado);
                }
            } catch (JexlException ex) {
                resultado.setText("=No válida");
            }
        }

        switch (text) {
            case "+":
                if (!resultado.getText().toString().equals("")) {
                    expresion = strResultado + expresion.substring(expresion.length() - 1, expresion.length());
                    historial.setText(expresion);
                    resultado.setText("");
                }
                break;
            case "/":
                if (!resultado.getText().toString().equals("")) {
                    expresion = strResultado + expresion.substring(expresion.length() - 1, expresion.length());
                    historial.setText(expresion);
                    resultado.setText("");
                }
                break;
            case "*":
                if (!resultado.getText().toString().equals("")) {
                    expresion = strResultado + expresion.substring(expresion.length() - 1, expresion.length());
                    historial.setText(expresion);
                    resultado.setText("");
                }
                break;
            case "-":
                if (!resultado.getText().toString().equals("")) {
                    expresion = strResultado + expresion.substring(expresion.length() - 1, expresion.length());
                    historial.setText(expresion);
                    resultado.setText("");
                }
                break;
            case "C":
                expresion = "";
                strNum = "";
                historial.setText("");
                resultado.setText("");
                break;
        }
    }
}
