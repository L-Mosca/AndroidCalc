package br.com.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button0,
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
            button9,
            buttonClear,
            buttonBackspace,
            buttonEqual,
            buttonSum,
            buttonSub,
            buttonDiv,
            buttonTimes,
            buttonDot,
            buttonPar1,
            buttonPar2;

    private TextView tvOperator,
            tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        // Define os eventos de click para cada evento dos botões
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonSum.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonTimes.setOnClickListener(this);
        buttonPar1.setOnClickListener(this);
        buttonPar2.setOnClickListener(this);

        // Evento de clique do botao de limpar (C)
        buttonClear.setOnClickListener(v -> {
            tvOperator.setText("");
            tvResult.setText("");
        });

        // Evento de clique do botao backspace
        buttonBackspace.setOnClickListener(v -> {
            TextView operator = findViewById(R.id.text_view_operator);
            String string = operator.getText().toString();

            // se a textview nao estive vazia, apaga o ultimo caracter
            if (!string.isEmpty()) {
                String expressao = string.substring(0, string.length() - 1);
                operator.setText(expressao);
            }
            tvResult.setText("");
        });

        // Evento de clique do botao de igual
        buttonEqual.setOnClickListener(v -> {

            try {
                // a classe expression builder faz todos os calculos
                Expression expression = new ExpressionBuilder(tvOperator.getText().toString()).build();

                // Evaluate e o metodo que avalia a expressao e faz todos os tratamentos necessários
                double result = expression.evaluate();

                long longResult = (long) result;

                if (result == (double) longResult) {
                    tvResult.setText(String.valueOf(longResult));
                } else {
                    tvResult.setText(String.valueOf(result));
                }
            } catch (Exception e) {
            }


        });

    }


    // Inicia todos os componentes com seus respectivos IDs do arquivo XML
    private void initComponents() {

        // Botões
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonClear = findViewById(R.id.button_clear);
        buttonBackspace = findViewById(R.id.button_backspace);
        buttonEqual = findViewById(R.id.button_equals);
        buttonSum = findViewById(R.id.button_sum);
        buttonSub = findViewById(R.id.button_sub);
        buttonDiv = findViewById(R.id.button_div);
        buttonTimes = findViewById(R.id.button_mult);
        buttonDot = findViewById(R.id.button_dot);
        buttonPar1 = findViewById(R.id.button_par1);
        buttonPar2 = findViewById(R.id.button_par2);

        // Text Views
        tvOperator = findViewById(R.id.text_view_operator);
        tvResult = findViewById(R.id.text_view_visor_result);
    }


    // Adiciona as expressões nos visores
    public void addExpression(String string, boolean clear_data) {

        // se o resultado estiver vazio
        if (tvResult.getText().equals("")) {
            tvOperator.setText(" ");
        }

        // se cleardata for verdadeiro, limpa o reusltado
        if (clear_data) {
            tvResult.setText(" ");
            tvOperator.append(string);
        } else {
            tvOperator.append(tvResult.getText());
            tvOperator.append(string);
            tvResult.setText(" ");
        }
    }


    // Testa o evento de click de todos os botões
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_0:
                addExpression("0", true);
                break;
            case R.id.button_1:
                addExpression("1", true);
                break;
            case R.id.button_2:
                addExpression("2", true);
                break;
            case R.id.button_3:
                addExpression("3", true);
                break;
            case R.id.button_4:
                addExpression("4", true);
                break;
            case R.id.button_5:
                addExpression("5", true);
                break;
            case R.id.button_6:
                addExpression("6", true);
                break;
            case R.id.button_7:
                addExpression("7", true);
                break;
            case R.id.button_8:
                addExpression("8", true);
                break;
            case R.id.button_9:
                addExpression("9", true);
                break;

            case R.id.button_dot:
                addExpression(",", true);
                break;
            case R.id.button_sum:
                addExpression(" + ", false);
                break;
            case R.id.button_sub:
                addExpression(" - ", false);
                break;
            case R.id.button_div:
                addExpression(" / ", false);
                break;
            case R.id.button_mult:
                addExpression(" * ", false);
                break;
            case R.id.button_par1:
                addExpression("(", false);
                break;
            case R.id.button_par2:
                addExpression(")", false);
                break;
        }
    }
}
