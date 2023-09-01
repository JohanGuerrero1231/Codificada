/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package markus.tcodificada;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
public class codi extends JFrame implements ActionListener {

    private int a = 0, a1 = 10000, a2 = 5000, a3 = 3000, perro, tamaño, horas, guardar, guardar1;
    JLabel Lperros;
    JTextField Jperros;
    JButton Bingresar;
    JLabel Ltamaño;
    JComboBox<String> Jtamaño;
    JLabel Lhoras;
    JTextField Jhoras;
    JButton Bcalcular;
    JButton Bsiguiente;
    JLabel Ltotal;
    JTextField Jtotal;
    FlowLayout flow;

    public codi() {
        setBounds(100, 100, 500, 200);
        //setLayout(new FlowLayout());
        flow = new FlowLayout(FlowLayout.CENTER, 3, 3);
        setLayout(flow);
        Lperros = new JLabel("Cantidad de perros");
        Jperros = new JTextField(10);
        Bingresar = new JButton("Ingresar");
        Ltamaño = new JLabel("¿Que tamaño tiene?");
        Jtamaño = new JComboBox<String>();
        Lhoras = new JLabel("¿Cuentas horas de paseo para ese perro?");
        Jhoras = new JTextField(10);
        Bcalcular = new JButton("Calcular");
        Bsiguiente = new JButton("Siguiente");
        Ltotal = new JLabel("Total a pagar:");
        Jtotal = new JTextField(10);

        add(Lperros);
        add(Jperros);
        add(Bingresar);
        add(Ltamaño);
        add(Jtamaño);
        Jtamaño.addItem("Elige");
        Jtamaño.addItem("Grande");
        Jtamaño.addItem("Mediano");
        Jtamaño.addItem("Pequeño");
        add(Lhoras);
        add(Jhoras);
        add(Bcalcular);
        add(Bsiguiente);
        add(Ltotal);
        add(Jtotal);
        Ltamaño.setVisible(false);
        Jtamaño.setVisible(false);
        Lhoras.setVisible(false);
        Jhoras.setVisible(false);
        Bsiguiente.setVisible(false);
        Ltotal.setVisible(false);
        Jtotal.setVisible(false);
        Bcalcular.setVisible(false);
        Bingresar.addActionListener(this);
        Bsiguiente.addActionListener(this);
        Bcalcular.addActionListener(this);

        flow.setHgap(flow.getHgap() + 60);
        flow.setVgap(flow.getVgap() + 20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String A = e.getActionCommand();
        if (A.equals("Ingresar")) {
            Lperros.setVisible(false);
            Jperros.setVisible(false);
            Bingresar.setVisible(false);
            this.perro = Integer.parseInt(Jperros.getText());
            if (this.perro >= 1) {
                Ltamaño.setVisible(true);
                Jtamaño.setVisible(true);
                Lhoras.setVisible(true);
                Jhoras.setVisible(true);
                Bsiguiente.setVisible(true);
            }
        }
        if (A.equals("Siguiente")) {
            if (this.perro > this.a) {
                this.tamaño = Jtamaño.getSelectedIndex();
                this.horas = Integer.parseInt(Jhoras.getText());
                if (this.tamaño == 1) {
                    this.guardar = this.a1 * this.horas;
                    this.guardar1 = this.guardar + this.guardar1;
                } else if (this.tamaño == 2) {
                    this.guardar = this.a2 * this.horas;
                    this.guardar1 = this.guardar + this.guardar1;
                } else if (this.tamaño == 3) {
                    this.guardar = this.a3 * this.horas;
                    this.guardar1 = this.guardar + this.guardar1;
                } else {
                    JOptionPane.showConfirmDialog(this, "Elige un tamaño:");
                }
                this.a = this.a + 1;
                Jhoras.setText(null);
                Jtamaño.setSelectedIndex(0);
            }
            if (this.perro == this.a) {
                Ltamaño.setVisible(false);
                Jtamaño.setVisible(false);
                Lhoras.setVisible(false);
                Jhoras.setVisible(false);
                Bcalcular.setVisible(true);
                Bsiguiente.setVisible(false);
            }
        }
        if (A.equals("Calcular")) {
            Ltotal.setVisible(true);
            Jtotal.setVisible(true);
            Bcalcular.setVisible(false);
            if (this.perro > 1) {
                this.guardar = this.guardar1 / 100;
                this.guardar = this.guardar * 10;
                this.guardar = this.guardar1 - this.guardar;
            }
            Jtotal.setText(Integer.toString(this.guardar));
        }
    }
}
