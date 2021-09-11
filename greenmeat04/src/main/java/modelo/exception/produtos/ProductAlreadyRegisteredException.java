package modelo.exception.produtos;

public class ProductAlreadyRegisteredException extends Exception {

	public ProductAlreadyRegisteredException(String mensagem) {
		super(mensagem);

	}
}