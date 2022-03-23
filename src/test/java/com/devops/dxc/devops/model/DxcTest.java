package com.devops.dxc.devops.model;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

    
public class DxcTest {

    @BeforeEach
    public void setup(){} 
    
    @Test
    public void calculo10xCientoSaldoAhorradoSuperior150UFDeberiaDevolverMaximoRetiro() throws Exception {
        Dxc dxc = new Dxc(50000000, 1200000);        
        assertEquals(dxc.getMaximoRetiro(), dxc.getDxc());
    }

    @Test
    public void calculo10xCientoMenorIgual1MillonConSaldoAhorradoMayorIgual1MillonDeberiaDevolver1Millon() throws Exception {
        Dxc dxc = new Dxc(9999999, 1200000);
        assertEquals(1000000, dxc.getDxc());
    }

    @Test
    public void calculo10xCientoSaldoAhorradoMenor1MillonDeberiaDevolverSaldoAhorrado() throws Exception {
        Dxc dxc = new Dxc(900000, 1200000);
        assertEquals(dxc.getAhorro(), dxc.getDxc());
    }
    
    @Test
    public void calculo10xCientoCasoBaseDeberiaDevolver10xCientoDelSaldoAhorrado() throws Exception {
        Dxc dxc = new Dxc(25000000, 1200000);
        assertEquals(dxc.getAhorro() * 0.1, dxc.getDxc());
    }

    @Test
    public void calculoImpuestoAlRetirarDeberiaDevolver10xCientoDelRetiro() throws Exception {
        Dxc dxc = new Dxc(25000000, 1200000);
        assertEquals(dxc.getDxc() * 0.1, dxc.getImpuesto());
    }

    @Test
    public void calculoSaldoDespuesDelRetiroCasoBaseDeberiaDevolverSaldoAhorradoMenosRetiro() throws Exception {
        Dxc dxc = new Dxc(25000000, 1200000);
        assertEquals(dxc.getAhorro() - dxc.getDxc() , dxc.getSaldo());
    }

    @Test
    public void calculoSaldoDespuesDeMaximoRetiroDeberiaDevolverSaldoAhorradoMenosMontoMaximoRetiro() throws Exception {
        Dxc dxc = new Dxc(50000000, 1200000);        
        assertEquals(dxc.getAhorro() - dxc.getMaximoRetiro(), dxc.getSaldo());
    }

    @Test
    public void calculoSaldoDespuesDeMinimoRetiroDeberiaDevolverSaldoAhorradoMenosMontoMinimoRetiro() throws Exception {
        Dxc dxc = new Dxc(9999999, 1200000);        
        assertEquals(dxc.getAhorro() - 1000000, dxc.getSaldo());
    }

    @Test
    public void calculoSaldoDespuesDeRetirarTodoAhorroDeberiaDevolver0() throws Exception {
        Dxc dxc = new Dxc(600000, 1200000);        
        assertEquals(0, dxc.getSaldo());
    }

    @Test
    public void calculo10xCientoConAhorroOSueldoNegativosDeberiaDevolver0() throws Exception {
        Dxc dxc = new Dxc(-1, -1);        
        assertEquals(0, dxc.getDxc());
    }
    
    @Test
    public void calculo10xCientoConSaldoAhorradoNegativoDeberiaDevolver0() throws Exception {
        Dxc dxc = new Dxc(-1, 1);        
        assertEquals(0, dxc.getDxc());
    }

    @Test
    public void calculo10xCientoConSueldoNegativoDeberiaDevolver0() throws Exception {
        Dxc dxc = new Dxc(0, -1);        
        assertEquals(0, dxc.getDxc());
    }

    @Test
    public void setterAhorro() throws Exception {
        Dxc dxc = new Dxc();
        dxc.setAhorro(25000000);
        assertEquals(25000000, dxc.getAhorro());
    }

    @Test
    public void setterSueldo() throws Exception {
        Dxc dxc = new Dxc();
        dxc.setSueldo(1200000);
        assertEquals(1200000, dxc.getSueldo());
    }
}
    