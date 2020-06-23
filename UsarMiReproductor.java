class UsarMiReproductor{
	
	public static void main(String[] args) {

		MiReproductor mr = new MiReproductor();
		mr.inicializar();

		for (int i=1; i<10; i++) {
			mr.reproducirNota(60, 1, 1000);
			mr.reproducirNota(64, 1, 1000);
			mr.reproducirNota(65, 1, 1000);
			mr.reproducirNota(67, 1, 1000);
		}
			
		mr.finalizar();

	}
}