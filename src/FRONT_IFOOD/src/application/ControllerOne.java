package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Platform;

public class ControllerOne {
	
	
	@FXML
    private ListView<String> adicionais;

    @FXML
    private Button adicionar;

    

    @FXML
    private Button concluir;

    

    @FXML
    private ListView<String> listprodutos;

    

    @FXML
    private ListView<String> pedido;
    @FXML
    private void iniciandolistas() {
    	listprodutos.getItems().addAll("opcao 1", "opcao 2", "opcao 3");
    	adicionais.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	listprodutos.setOnMouseClicked(event -> {
    		String opcao = listprodutos.getSelectionModel().getSelectedItem();
    		if (opcao != null) {
    			carregaradicionais();
    			
    		}
    	});
    }
	@FXML
	private void carregaradicionais() {
		adicionais.getItems().clear();
		
		String produto = listprodutos.getSelectionModel().getSelectedItem();
		if (produto != null) {
			adicionais.getItems().addAll("opcao 1", "opcao 2", "opcao 3");
		}
	}
	@FXML
	private void handleadicionar(ActionEvent event) throws Exception {
		String produto = listprodutos.getSelectionModel().getSelectedItem();
		if (produto == null) {
			System.out.println("selecione um item do cardapio");
			return;
		}
		
		var Adicionais = adicionais.getSelectionModel().getSelectedItems();
		if (Adicionais.size() > 3) {
			System.out.println("somente tres item por produto");
			return;
		}
		String Pedido = produto + " com " + String.join(",", Adicionais);
		pedido.getItems().add(Pedido);
		listprodutos.getSelectionModel().clearSelection();
	    adicionais.getSelectionModel().clearSelection();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FXML
    private TextField bairro;

    @FXML
    private TextField cep;

    @FXML
    private TextField ceppesquisa;
    @FXML
    private void handleceppesquisa (ActionEvent event) throws Exception {
    	String Cep = cep.getText();   
    	
    	try {
    		if (Cep.isEmpty() || !Cep.matches("\\d+")) {
    			throw new IllegalArgumentException("Algo de errado");
    		}
    	}catch (IllegalArgumentException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    }

    @FXML
    private TextField cidade;

    @FXML
    private TextField complemento;

    @FXML
    private TextField estado;

    @FXML
    private Button finalizar;
    
    @FXML
    private Label labelendereco;

    @FXML
    private TextField numero;

    @FXML
    private Button pesquisar;

    @FXML
    private TextField referencia;

    @FXML
    private TextField rua;

    @FXML
    private TextField tipoendereco;
    @FXML
    private void handleRegistroendereco (ActionEvent event) throws Exception {
    	
    	 String Rua = rua.getText();
    	 String Numero = numero.getText();
    	 String Cep = cep.getText();
    	 String Bairro = bairro.getText();
		 String Cidade = cidade.getText();
		 String Estado = estado.getText();
		 String Referencia = referencia.getText();
		 String Complemento = complemento.getText();
		 String Tipoendereco = tipoendereco.getText();
    	 
    	 try {
    		 if (Rua.isEmpty() || Numero.isEmpty() || Cep.isEmpty() || Bairro.isEmpty() || Cidade.isEmpty() || Estado.isEmpty() || Referencia.isEmpty() || Complemento.isEmpty() || Tipoendereco.isEmpty()) {
    			 throw new IllegalArgumentException("Algo de errado");
    		 }
    		 
    		if (!Cep.matches("\\d+") || !Cep.matches("\\d+")) {
    			throw new IllegalArgumentException("Algo de errado");
    		}
    		 if (Bairro.matches("[a-zA-Z]+") && Cidade.matches("[a-zA-Z]+") && Estado.matches("[a-zA-Z]+") && Referencia.matches("[a-zA-Z]+") && Complemento.matches("[a-zA-Z]+") && Tipoendereco.matches("[a-zA-Z]+")) {
    			 System.out.println("campos corretos");
    		 } else {
    			 throw new IllegalArgumentException("Algo de errado");
    		 }
    		 
    	 } catch (IllegalArgumentException e) {
    		 e.printStackTrace();
    	 }
    	 
    	 
    }
	
	
	
	   

	@FXML
	private Button finalizarcompra;

	@FXML
	private MenuButton formadepagamento;
	
	@FXML
	private ListView<String> llistafinal;    

	@FXML
	private Button restaurante;

	@FXML
	private Label tempo;
	@FXML
	private void handletemporizador (ActionEvent event) throws Exception{
		
		
		for (int contador = 0; contador <= 2; contador++) {
			
			new Thread(() -> {
	            try {
	                for (int segundos = 0; segundos <= 36; segundos++) {
	                	final String time = String.valueOf(segundos);
	                	Platform.runLater(() -> tempo.setText(time));
	            		Thread.sleep(1000);
	                }
	                
	                
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }).start();
			
		}
		
	
	}
	@FXML
	private void handlefinalizarcompra (ActionEvent event) throws Exception {
			System.out.println("finalizar clicado");
			handletemporizador(event);
		try {
			
			if (llistafinal.getItems().isEmpty()) {
				throw new Exception("Algo de errado");
			}
			if (formadepagamento.getText() == null || formadepagamento.getText().isEmpty()) {
				throw new Exception("Algo de errado");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

   

    

    @FXML
    private ListView<String> historicodepedidos;

    @FXML
    private ListView<String> lista;
    @FXML
    private void iniciandoLista() {
    	lista.getItems().addAll("opcao 1", "opcao 2", "opcao 3");
    	lista.setOnMouseClicked(event -> {
    		String opcao = lista.getSelectionModel().getSelectedItem();
    		if (opcao != null) {
    			pagina(opcao);
    			
    		}
    	});
    }
    private void pagina(String item) {
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/restauranteprodutos.fxml"));
	        Parent root = loader.load();
	        ControllerOne controller = loader.getController();
	        controller.iniciandolistas();
	        Scene scene = new Scene(root);
	        Stage primaryStage = (Stage) lista.getScene().getWindow();
	        primaryStage.setScene(scene);
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    	
    	
    	
    	
    }

	@FXML
	 private Button carrinho;
	@FXML
	private void handlercarrinho (ActionEvent event) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/carrinho.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        Stage primaryStage = (Stage) endereco.getScene().getWindow();
	        primaryStage.setScene(scene);
	}

	@FXML
	private Button endereco;
	@FXML
	private void handlerendereco (ActionEvent event) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/resgistroendereco.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        Stage primaryStage = (Stage) endereco.getScene().getWindow();
	        primaryStage.setScene(scene);
	}

	@FXML
	private Button meuspedidos;
	@FXML
	private void handlermeuspedidos (ActionEvent event) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/historicodepedidos.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) meuspedidos.getScene().getWindow();
			primaryStage.setScene(scene);
	}

	@FXML
	private Button restaurantes;
	@FXML
	private void handlerestaurantes (ActionEvent event) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/restaurantelista.fxml"));
	        Parent root = loader.load();
	        ControllerOne controller = loader.getController();
	        controller.iniciandoLista();
	        Scene scene = new Scene(root);
	        Stage primaryStage = (Stage) restaurantes.getScene().getWindow();
	        primaryStage.setScene(scene);
	        
	}
	
	
	
    
    @FXML
    private TextField password;

    @FXML
    private Button entrar;

    @FXML
    private TextField login;
    @FXML
    private void handlelogin (ActionEvent event) throws Exception {
    	
    	String Login = login.getText();
    	String Password = password.getText();
    	
    	 try {
            
    		 if (!Password.matches("\\d+")) {
     			throw new IllegalArgumentException("Algo de errado");
     		 }
    		 if (!Login.matches("[a-zA-Z]+")) {
    			 throw new IllegalArgumentException("Algo de errado");
    		 }
    		 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/home.fxml"));
 	        Parent root = loader.load();
 	        Scene scene = new Scene(root);
 	        Stage primaryStage = (Stage) entrar.getScene().getWindow();
 	        primaryStage.setScene(scene);
             
         } catch (IllegalArgumentException e) {
        	 System.out.println("Apenas numeros na senha e letras no login");
             e.printStackTrace();
         }
    	 	
    	
    }
   
    
   
    
    

    
    

}
