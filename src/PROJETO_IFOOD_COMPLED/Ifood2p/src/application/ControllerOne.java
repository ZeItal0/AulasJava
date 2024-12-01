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
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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

    private String Pedido;
    
    private int id_pass;

    @FXML
    private ListView<String> pedido;
    
    @FXML
    private TextField bairro;

    @FXML
    private TextField cep;

    @FXML
    private TextField ceppesquisa;
    
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
    private Label labelenderecoregistrado;

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
	private Button finalizarcompra;

	@FXML
	private MenuButton formadepagamento;
	
    @FXML
    private ListView<String> historicodepedidos;
    
    @FXML
	private ListView<String> listafinal;
    
    @FXML
	private Button restaurante;

	@FXML
	private Label tempo;
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button3;
	@FXML
	private Button button4;
	@FXML
	private Button button5;
	
    private void iniciandolistas(int item) {
    	listprodutos.getItems().clear();
    	ProductDAO productDAO = new ProductDAO();
    	List<Product> produtos = productDAO.getallprodutos(item);
    	id_pass = item;
    	for (Product product : produtos) {
            listprodutos.getItems().add(product.getName());
        }
    	adicionais.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	listprodutos.setOnMouseClicked(event -> {
    		String opcao = listprodutos.getSelectionModel().getSelectedItem();
    		for (Product product : produtos) {
    			int id = product.getId();
    			if (opcao != null) {
    				carregaradicionais(id);
    			
    			}
    		}
    	});
    }
	
	private void carregaradicionais(int id_adicional) {
		adicionais.getItems().clear();
		FollowUpDAO followUpDAO = new FollowUpDAO();
		List<FollowUp> acompanhamentos = followUpDAO.getalladicional(id_adicional);
		
		for (FollowUp followUp : acompanhamentos) {
			adicionais.getItems().add(followUp.getName());
		}
		
	}
	@FXML
	private void handleadicionar(ActionEvent event) throws Exception {
		String produto = listprodutos.getSelectionModel().getSelectedItem();
		if (produto == null) {
			System.out.println("selecione algo do cardapio");
			return;
		}
		
		var Adicionais = adicionais.getSelectionModel().getSelectedItems();
		if (Adicionais.size() > 3) {
			System.out.println("somente tres acompanhamento por produto");
			return;
		}
		Pedido = produto + " com " + String.join(",", Adicionais);
		pedido.getItems().add(Pedido);
		listprodutos.getSelectionModel().clearSelection();
	    adicionais.getSelectionModel().clearSelection();
	}
	
	
	@FXML
	private void handleconcluir (ActionEvent event) throws Exception  {
		if(!pedido.getItems().isEmpty()) { 
			OrderDAO orderDAO = new OrderDAO();
			Order order = new Order(null, 0, 0, null, null, null, 0, null, null, null, null, null);
			
		    List<ProductOrder> listadepedidos = new ArrayList<>();
		    order.setId(id_pass);
		    
		    for (String item : pedido.getItems()) {
		    	ProductOrder productOrder = new ProductOrder(null, null, 0);
		    	Product product = new Product(null, 0, null, null);
		    	product.setName(item);
		    	productOrder.setProduct(product);
		    	listadepedidos.add(productOrder);
		    }
		    
		    order.setProductOrder(listadepedidos);
		    orderDAO.setallprodutoscarrinho(order);
			handlercarrinho(event);
		}
    }
	
    @FXML
    private void handleceppesquisa (ActionEvent event) throws Exception {
    	String Cep = ceppesquisa.getText();
    	try {
    		if (Cep.isEmpty() || !Cep.matches("\\d+")) {
    			throw new IllegalArgumentException("Algo de errado");
    		}
    		ViaCepAdress pesquisa = new ViaCepAdress();
    		Adress endereco = pesquisa.pesquisar(Cep);
    		rua.setText(endereco.getRoad().replace("\"", ""));
    		bairro.setText(endereco.getNeighborhood().replace("\"", ""));
    		cidade.setText(endereco.getCity().replace("\"", ""));
    		estado.setText(endereco.getState().replace("\"", ""));
    		cep.setText(Cep);
    		
    		String info = "Rua: " + endereco.getRoad() + "\n" +
                    	  "Bairro: " + endereco.getNeighborhood() + "\n" +
                          "Cidade: " + endereco.getCity() + "\n" +
                          "Estado: " + endereco.getState();
    		labelendereco.setText(info);
    		
    		
    		
    	}catch (IllegalArgumentException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    }

   
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
    		 
    		if (!Cep.matches("\\d+")) {
    			throw new IllegalArgumentException("Algo de errado");
    		}
    		 if (Bairro.matches("[a-zA-ZáéíóúÁÉÍÓÚçÇ ]+") && Cidade.matches("[a-zA-ZáéíóúÁÉÍÓÚçÇ ]+") && Estado.matches("[a-zA-ZáéíóúÁÉÍÓÚçÇ ]+") && Referencia.matches("[a-zA-ZáéíóúÁÉÍÓÚçÇ ]+") && Complemento.matches("[a-zA-ZáéíóúÁÉÍÓÚçÇ ]+") && Tipoendereco.matches("[a-zA-ZáéíóúÁÉÍÓÚçÇ ]+")) {
    			 System.out.println("campos corretos");
    		 } else {
    			 throw new IllegalArgumentException("Algo de errado");
    		 }
    		 
    		 AdressDAO adressDAO = new AdressDAO();
    		 Adress Endereco = new Adress("", "", "", "", "", 0, "", "", "", null, null);
    		 Endereco.setRoad(Rua);
    		 Endereco.setNumber(Numero);
    		 Endereco.setCity(Cidade);
    		 Endereco.setState(Estado);
    		 Endereco.setReference_point(Referencia);
    		 Endereco.setZip_code(Integer.parseInt(Cep));
    		 Endereco.setComplement(Complemento);
    		 Endereco.setAddress_type(Tipoendereco);
    		 Endereco.setNeighborhood(Bairro);
    		 adressDAO.enderecoregistro(Endereco);
    		 RegisteredAdress.getInstance().setRegisteredAdress(Rua +"-"+ Numero + "-" + Bairro +  "-" + Estado); 
    		 enderecoset();
    		 
    		 rua.clear();
    		 numero.clear();
    		 cep.clear();
    		 bairro.clear();
    		 cidade.clear();
    		 estado.clear();
    		 referencia.clear();
    		 complemento.clear();
    		 tipoendereco.clear();
    		 
    	 } catch (IllegalArgumentException e) {
    		 e.printStackTrace();
    	 }
    	 
    	 
    }
	
	private void enderecoset () {
		String endereco = RegisteredAdress.getInstance().getRegisteredAdress();
		labelenderecoregistrado.setText(endereco);
	}
	   

	
	@FXML
	private void handleformadepagamento () {
		PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO();
		List<PaymentMethod> methods = paymentMethodDAO.getallpagamentos();
		formadepagamento.getItems().clear();
		
		for (PaymentMethod paymentMethod : methods) {
			MenuItem menuItem = new MenuItem(paymentMethod.getShape());
			menuItem.setOnAction(event -> formadepagamento.setText(paymentMethod.getShape()));
			formadepagamento.getItems().add(menuItem);
			
		}
	}
	
	
	
	private void iniciarListafinal () throws Exception {
		OrderDAO orderDAO = new OrderDAO();
		List<Order> produtoscarrinho = orderDAO.getallprodutoscarrinho();
		
		for (Order order : produtoscarrinho) {
			listafinal.getItems().add(order.getObservation());
		}
		handleformadepagamento();
	}

	@FXML
	private void handletemporizador (ActionEvent event) throws Exception{
		
			new Thread(() -> {
	            try {
	                for (int segundos = 0; segundos <= 36; segundos++) {
	                	final String time = String.valueOf(segundos);
	                	Platform.runLater(() -> tempo.setText(time));
	            		Thread.sleep(1000);
	            		if(segundos == 8) {
	            			button1.setStyle("-fx-background-color:greenyellow");
	            		} else if(segundos == 12) {
	            			button2.setStyle("-fx-background-color:greenyellow");
	            			button3.setStyle("-fx-background-color:greenyellow");
	            		} else if(segundos == 24) {
	            			button4.setStyle("-fx-background-color:greenyellow");
	            		}else if (segundos == 36) {
	            			button5.setStyle("-fx-background-color:greenyellow");
	            			salvarpedidos();
	            			OrderDAO orderDAO = new OrderDAO();
	            			orderDAO.deletecarrinho();
		            		Platform.runLater(() ->{
		            			formadepagamento.getItems().clear();
			            		listafinal.getItems().clear();
			            		tempo.setText(" ");
		            		});
	            		}
	            		
	                }
	                
	                
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }).start();
			
		
	
	}
	@FXML
	private void handlefinalizarcompra (ActionEvent event) throws Exception {
		try {
			String endereco = RegisteredAdress.getInstance().getRegisteredAdress();
			if (listafinal.getItems().isEmpty() || endereco.isEmpty() || endereco == null) {
				throw new Exception("Algo de errado");
			}
			if (formadepagamento.getText() == null || formadepagamento.getText().isEmpty()) {
				throw new Exception("Algo de errado");
			}
			handletemporizador(event);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void salvarpedidos () {
		DeliveryHistoryDAO deliveryHistoryDAO = new DeliveryHistoryDAO();
		Order order = new Order(null, 0, 0, null, null, null, 0, null, null, null, null, null);
		List<DeliveryHistory> delivery = new ArrayList<>();
		
		for (String itens : listafinal.getItems()) {
			DeliveryHistory deliveryHistory = new DeliveryHistory(null, null);
			order.setObservation(itens);
			deliveryHistory.setOrder(order);
			delivery.add(deliveryHistory);
		}
		order.setDeliveryHistory(delivery);
		deliveryHistoryDAO.setallprodutoshistorico(order);
	}
	

   
    @FXML
    private void listahistorico () throws Exception {
    	
    	DeliveryHistoryDAO deliveryHistoryDAO = new DeliveryHistoryDAO();
    	List<DeliveryHistory> history = deliveryHistoryDAO.getallprodutoshistorico();
    	
    	for (DeliveryHistory delivery : history) {
    		historicodepedidos.getItems().add(delivery.getDetails());
    	}
    	
    }

    @FXML
    private ListView<String> lista;
    @FXML
    private void iniciandoLista() {
    	RestaurantDAO restaurantDAO = new RestaurantDAO();
    	List<Restaurant> restaurants = restaurantDAO.getallrestaurantNames();
    	
    	for (Restaurant restaurant : restaurants) {
            lista.getItems().add(restaurant.getName());
        }
    		
    	
    	lista.setOnMouseClicked(event -> {
    		String opcao = lista.getSelectionModel().getSelectedItem();
    		if (opcao != null) {
    			for (Restaurant restaurant : restaurants) {
    					int id = restaurant.getId();
    				if (restaurant.getName().equals(opcao)) {
    					System.out.println(id);
    					pagina(id);
    					break;
    				}
    			}
    		}
    	});
    }
    private void pagina(int item) {
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/restauranteprodutos.fxml"));
	        Parent root = loader.load();
	        ControllerOne controller = loader.getController();
	        controller.iniciandolistas(item);
	        controller.enderecoset();
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/carrinho.fxml"));
	        Parent root = loader.load();
	        ControllerOne controller = loader.getController();
	        controller.iniciarListafinal();
	        controller.enderecoset();
	        Scene scene = new Scene(root);
	        Stage primaryStage = (Stage) carrinho.getScene().getWindow();
	        primaryStage.setScene(scene);
	}

	@FXML
	private Button endereco;
	@FXML
	private void handlerendereco (ActionEvent event) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/resgistroendereco.fxml"));
	        Parent root = loader.load();
	        ControllerOne controller = loader.getController();
	        controller.enderecoset();
	        Scene scene = new Scene(root);
	        Stage primaryStage = (Stage) endereco.getScene().getWindow();
	        primaryStage.setScene(scene);
	}

	@FXML
	private Button meuspedidos;
	@FXML
	private void handlermeuspedidos (ActionEvent event) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/historicodepedidos.fxml"));
			Parent root = loader.load();
			ControllerOne controller = loader.getController();
			controller.listahistorico();
			controller.enderecoset();
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) meuspedidos.getScene().getWindow();
			primaryStage.setScene(scene);
	}

	@FXML
	private Button restaurantes;
	@FXML
	private void handlerestaurantes (ActionEvent event) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/restaurantelista.fxml"));
	        Parent root = loader.load();
	        ControllerOne controller = loader.getController();
	        controller.iniciandoLista();
	        controller.enderecoset();
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
    		 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/home.fxml"));
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
