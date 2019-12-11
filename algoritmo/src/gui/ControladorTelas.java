package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import basico.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;

public class ControladorTelas {

    @FXML
    private ResourceBundle resources;
    @FXML
    private Stage dialogStage;

    @FXML
    private URL location;

    @FXML
    private Button Continuar;

    @FXML
    private Button Adicionar;
    @FXML
    private TextField nome;
    @FXML
    private TableView<Pessoa> tabela;
    @FXML
    private TableColumn<Pessoa, String> cidade;
    @FXML
    private Button add;

    @FXML
    private Button adicionarLigacao;

    @FXML
    private Button sair;

    @FXML
    private TableView<Pessoa> tabelapart;

    @FXML
    private TableColumn<Pessoa, String> participantes;

    RepositorioPessoa rep = RepositorioPessoa.getInstance();
    ConnectComponents c = new ConnectComponents();

    @FXML
    void Continuar(ActionEvent event) throws IOException {
        Parent janela = FXMLLoader.load(getClass().getResource("/telas/fxmls/Tela2.fxml"));
        Scene cena = new Scene(janela);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(cena);
        stage.show();

        //CC();
    }

    @FXML
    void Adicionar(ActionEvent event) throws IOException {
        Parent janela = FXMLLoader.load(getClass().getResource("/telas/fxmls/NovoParticipante.fxml"));
        Scene cena = new Scene(janela);
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.setScene(cena);
        stage.show();

    }

    @FXML
    public void NovoParticipante(ActionEvent event) throws IOException {

        if (!((String) nome.getText()).isEmpty() && tabela.getSelectionModel().getSelectedItem() != null) {
            Pessoa p = new Pessoa((String) nome.getText(), tabela.getSelectionModel().getSelectedItem().getCidade());
            rep.cadastrar(p);
        } else if (tabela.getSelectionModel().getSelectedItem() != null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Nome Invalido");
            alert.setHeaderText("Por favor, digite um nome valido");
            alert.setContentText("O nome do Participante nao pode ser vazio");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Cidade nao selecionada");
            alert.setHeaderText("Por favor, selecione uma cidade");
            alert.setContentText("A cidade do Participante nao pode ser vazia");
            alert.showAndWait();
        }
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/fxmls/NovoParticipante2.fxml"));
            Scene cena = new Scene(root);
            Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            stage.setScene(cena);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @FXML
    public void removerParticipante() {

        if (tabela.getSelectionModel().getSelectedItem() != null) {
            rep.remover(tabelapart.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    public void CC() {
        //chamar nova tela para imprimir a quantidade de componentes conectados e ao apertar um botao mostrar o grafo
        System.out.println(c.retornarCC());
        rep.acao();
    }

    @FXML
    public void Clique() {

        rep.acao();
    }

    @FXML
    void AddLigacao(ActionEvent event) {
        if (tabelapart.getSelectionModel().getSelectedItem() != null) {
            rep.addConhecidos(rep.buscarInt((rep.getPessoas().size() - 1)), tabelapart.getSelectionModel().getSelectedItem());
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Conexao Invalida");
            alert.setHeaderText("Por favor, selecione um participante primeiro");
            alert.setContentText("O nome do Participante nao pode ser vazio");
            alert.showAndWait();
        }

    }

    @FXML
    void Sair(ActionEvent event) {
        try {
            Parent janela = FXMLLoader.load(getClass().getResource("/telas/fxmls/Tela1.fxml"));
            Scene cena = new Scene(janela);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(cena);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void iniciartabela1() {
        cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        tabela.setItems(FXCollections.observableList(rep.getCid()));
        tabela.refresh();

    }

    @FXML
    void iniciartabela2() {
        participantes.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelapart.setItems(FXCollections.observableList(rep.getPessoas()));
        tabelapart.refresh();

    }

    @FXML
    void initialize() {
        assert Continuar != null : "fx:id=\"Continuar\" was not injected: check your FXML file 'Tela1.fxml'.";
        assert Adicionar != null : "fx:id=\"Adicionar\" was not injected: check your FXML file 'Tela1.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'NovoParticipante.fxml'.";
        assert cidade != null : "fx:id=\"cidade\" was not injected: check your FXML file 'NovoParticipante.fxml'.";
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'NovoParticipante.fxml'.";
        assert adicionarLigacao != null : "fx:id=\"adicionarLigacao\" was not injected: check your FXML file 'NovoParticipante2.fxml'.";
        assert sair != null : "fx:id=\"sair\" was not injected: check your FXML file 'NovoParticipante2.fxml'.";
        assert tabelapart != null : "fx:id=\"tabelapart\" was not injected: check your FXML file 'NovoParticipante2.fxml'.";
        assert participantes != null : "fx:id=\"participantes\" was not injected: check your FXML file 'NovoParticipante2.fxml'.";
        try {
            iniciartabela1();
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }
        try {
            iniciartabela2();
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }

    }
}