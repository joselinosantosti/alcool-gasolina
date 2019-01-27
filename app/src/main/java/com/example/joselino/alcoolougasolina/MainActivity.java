package com.example.joselino.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtPrecoAlcool, edtPrecoGasolina;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        edtPrecoAlcool = findViewById( R.id.edtPrecoAlcool );
        edtPrecoGasolina = findViewById( R.id.edtPrecoGasolina );
        txtResultado = findViewById( R.id.tvResultado );
    }

    public void calcularPreco(View view){
        //recuperar valores digitados
        String precoAlcool = edtPrecoAlcool.getText().toString();
        String precoGasolina = edtPrecoGasolina.getText().toString();

        //Validar campos digitados
        Boolean camposValidados = this.validarCampos( precoAlcool, precoGasolina);
        if(camposValidados){
            this.calcularMelhorPreco( precoAlcool, precoGasolina );
        }
        else {
            txtResultado.setText( "Os campos de preço não podem ser vazios!" );
        }
    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina){

        //converter string para numeros
        double precoAlcool = Double.parseDouble( pAlcool );
        double precoGasolina = Double.parseDouble( pGasolina );

        //calculo
        double resultado = precoAlcool/precoGasolina;
        if(resultado >= 0.7) {
            txtResultado.setText( "Utilize gasolina" );
        }
        else {
            txtResultado.setText( "Utilize álcool" );
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;
        if(pAlcool == null || pAlcool.equals( "" )){
            camposValidados = false;
        }
        else if (pGasolina == null || pGasolina.equals( "" )){
            camposValidados = false;
        }
        return camposValidados;
    }
}
