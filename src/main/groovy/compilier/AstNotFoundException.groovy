package compilier

class AstNotFoundException extends Exception {
	public AstNotFoundException(String clsName){
		super(clsName)
	}
}
