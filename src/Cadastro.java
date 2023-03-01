import com.cadastro2023.Validacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro {
    private JPanel TelaCadastro;
    private JLabel nome;
    private JLabel cpf;
    private JLabel sexo;
    private JLabel dtNasc;
    private JLabel estadoCivil;
    private JLabel profissao;
    private JTextField valNome;
    private JTextField valCPF;
    private JRadioButton rbMasc;
    private JRadioButton rbFem;
    private JComboBox valEstadoCivil;
    private JTextField valProfissao;
    private JButton btnFim;
    private JTextField valDtNasc;

    public Cadastro(){

        valCPF.setDocument(new Validacao());

        btnFim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(valNome.getText().isEmpty()){
                    JOptionPane.showMessageDialog(TelaCadastro,"Nome não pode estar vazio", "Erro",JOptionPane.ERROR_MESSAGE);
                }
                else if(valCPF.getText().isEmpty()){
                    JOptionPane.showMessageDialog(TelaCadastro,"O campo CPF é obrigatório","Erro",JOptionPane.ERROR_MESSAGE);
                }
                else if(valEstadoCivil.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(TelaCadastro,"Selecione um estado civil", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else {

                    //S
                    String sexo = "";
                    if (rbMasc.isSelected()) sexo = "Masculino";
                    else if (rbFem.isSelected()) sexo = "Feminino";

                    //Profissão
                    String msgVaga = "";
                    String valPF = valProfissao.getText();
                    if (valProfissao.getText().isEmpty()) {
                        msgVaga ="Desempregado";
                    }
                    else if(valPF.equals("Analista de Sistemas") || valPF.equals("Engenheiro de Sistemas")) {
                        msgVaga = valProfissao.getText() + ". Vagas disponíveis";
                    }
                    else{
                        msgVaga = valProfissao.getText();
                    }

                    //Estado Civil
                    String EC = "";
                    if (valEstadoCivil.getSelectedIndex() == 1) EC = "Solteiro";
                    else if (valEstadoCivil.getSelectedIndex() == 2) EC = "Casado";
                    else if (valEstadoCivil.getSelectedIndex() == 3) EC = "Divorciado";
                    else EC = "Viúvo";

                    //Fim Cadastro
                    JOptionPane.showMessageDialog(null,
                            "Nome: " + valNome.getText() + "\nSexo: " + sexo + "\nEstado civil: " + EC + "\nProfissão: " + msgVaga);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame quadro = new JFrame("Cadastro");
        quadro.setContentPane(new Cadastro().TelaCadastro);
        quadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quadro.pack();
        quadro.setVisible(true);
    }
}
