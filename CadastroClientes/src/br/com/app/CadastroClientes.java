package br.com.app;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CadastroClientes extends JFrame {

    // Componentes da Interface
    private JTextField nomeCompletoField;
    private JTextField enderecoField;
    private JTextField cidadeField;
    private JComboBox<String> estadoComboBox;
    private JFormattedTextField telefoneField;
    private JRadioButton statusAtivo;
    private JRadioButton statusInativo;
    private ButtonGroup statusGroup;
    private JButton gravarDadosButton;
    private JButton cancelarCadastroButton;
    private JButton voltarButton;

    public CadastroClientes() {
        // Configuração básica do JFrame
        setTitle("Cadastrar Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Usando BorderLayout para organizar o cabeçalho, corpo e rodapé
        setLayout(new BorderLayout(10, 10));

        // 1. Painel Superior (Header)
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // ** BOTÕES: Removida a tentativa de carregar ícones para evitar NullPointerException **
        // Se desejar ícones, use a Solução Completa da resposta anterior (adicionando pasta 'resources')
        gravarDadosButton = new JButton("Gravar Dados");
        cancelarCadastroButton = new JButton("Cancelar Cadastro");

        // Estilização para simular o layout da imagem (opcional)
        gravarDadosButton.setBorderPainted(false);
        gravarDadosButton.setContentAreaFilled(false);
        cancelarCadastroButton.setBorderPainted(false);
        cancelarCadastroButton.setContentAreaFilled(false);

        headerPanel.add(gravarDadosButton);
        headerPanel.add(cancelarCadastroButton);

        add(headerPanel, BorderLayout.NORTH);

        // 2. Painel Central (Formulário)
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título de instrução
        JLabel instrucaoLabel = new JLabel("Preencha os dados corretamente e clique em Gravar Dados");
        instrucaoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(instrucaoLabel, gbc);

        // Espaçador
        gbc.gridy++;
        formPanel.add(new JLabel(""), gbc);

        // Nome Completo
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Nome Completo:"), gbc);

        nomeCompletoField = new JTextField(30);
        gbc.gridx = 1;
        formPanel.add(nomeCompletoField, gbc);

        // Endereço
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Endereço:"), gbc);

        enderecoField = new JTextField(30);
        gbc.gridx = 1;
        formPanel.add(enderecoField, gbc);

        // Cidade
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Cidade:"), gbc);

        cidadeField = new JTextField(30);
        gbc.gridx = 1;
        formPanel.add(cidadeField, gbc);

        // Estado (JComboBox)
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Estado:"), gbc);

        String[] estados = {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
        estadoComboBox = new JComboBox<>(estados);
        estadoComboBox.setPreferredSize(new Dimension(100, 25));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(estadoComboBox, gbc);

        // Telefone (JFormattedTextField)
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Telefone:"), gbc);

        try {
            // Máscara de telefone (XX) XXXX-XXXX
            MaskFormatter telefoneMask = new MaskFormatter("(##) ####-####");
            telefoneField = new JFormattedTextField(telefoneMask);
        } catch (ParseException e) {
            telefoneField = new JFormattedTextField();
        }
        telefoneField.setColumns(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(telefoneField, gbc);

        // Status (JRadioButtons)
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Status:"), gbc);

        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        statusAtivo = new JRadioButton("Ativo", true);
        statusInativo = new JRadioButton("Inativo");
        statusGroup = new ButtonGroup();
        statusGroup.add(statusAtivo);
        statusGroup.add(statusInativo);
        statusPanel.add(statusAtivo);
        statusPanel.add(statusInativo);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(statusPanel, gbc);


        // Adiciona o painel do formulário ao centro
        add(formPanel, BorderLayout.CENTER);


        // 3. Painel Inferior (Footer)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // ** BOTÃO: Removida a tentativa de carregar ícone **
        voltarButton = new JButton("Voltar");

        // Estilização para simular a aparência (opcional)
        voltarButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        voltarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        voltarButton.setBorderPainted(false);
        voltarButton.setContentAreaFilled(false);

        footerPanel.add(voltarButton);
        add(footerPanel, BorderLayout.SOUTH);

        // Configuração final da janela
        pack(); // Ajusta o tamanho da janela aos componentes
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Lógica de validação no botão "Gravar Dados"
        gravarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarEGravarDados();
            }
        });

        // Ações simples para os botões de controle
        cancelarCadastroButton.addActionListener(e -> dispose());
        voltarButton.addActionListener(e -> dispose());
    }

    /**
     * Valida se todos os campos obrigatórios estão preenchidos.
     */
    private void validarEGravarDados() {
        List<String> camposVazios = new ArrayList<>();

        // Validação de Nome, Endereço e Cidade (JTextFields)
        if (nomeCompletoField.getText().trim().isEmpty()) {
            camposVazios.add("Nome Completo");
        }
        if (enderecoField.getText().trim().isEmpty()) {
            camposVazios.add("Endereço");
        }
        if (cidadeField.getText().trim().isEmpty()) {
            camposVazios.add("Cidade");
        }

        // Validação do Estado (JComboBox)
        if (estadoComboBox.getSelectedIndex() <= 0) { // Assume que a primeira opção ("") é a vazia
            camposVazios.add("Estado");
        }

        // Validação do Telefone (JFormattedTextField)
        // Remove caracteres não-numéricos e verifica se sobrou algo
        if (telefoneField.getText().replaceAll("[^0-9]", "").isEmpty()) {
            camposVazios.add("Telefone");
        }

        if (camposVazios.isEmpty()) {
            // SUCESSO: Todos os campos estão preenchidos.
            String statusSelecionado = statusAtivo.isSelected() ? "Ativo" : "Inativo";

            JOptionPane.showMessageDialog(this,
                    "Cadastro realizado com sucesso!\n" +
                            "Nome: " + nomeCompletoField.getText() + "\n" +
                            "Endereço: " + enderecoField.getText() + "\n" +
                            "Cidade: " + cidadeField.getText() + "\n" +
                            "Estado: " + estadoComboBox.getSelectedItem() + "\n" +
                            "Telefone: " + telefoneField.getText() + "\n" +
                            "Status: " + statusSelecionado,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            // >> AQUI ENTRARIA A LÓGICA DE PERSISTÊNCIA (Banco de Dados, Arquivo, etc.) <<

        } else {
            // ERRO: Campos vazios encontrados.
            String mensagemErro = "Por favor, preencha os seguintes campos:\n";
            for (String campo : camposVazios) {
                mensagemErro += "- " + campo + "\n";
            }

            JOptionPane.showMessageDialog(this,
                    mensagemErro,
                    "Erro de Preenchimento",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Garante que a GUI seja executada na Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new CadastroClientes().setVisible(true);
        });
    }
}