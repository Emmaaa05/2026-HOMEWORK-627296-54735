package it.uniroma3.diadia;

public class IOSimulator implements IO{
	private String[] input;
	private String[] output;
	private int indiceIn;
	private int indiceOut;
	
	public IOSimulator(String[] input) {
		this.input=input;
		this.output = new String[100];
		this.indiceIn=0;
		this.indiceOut=0;
	}
	
	@Override
	public void mostraMessaggio(String msg) {
		if(indiceOut < output.length)
			output[indiceOut++] = msg;
	}
	
	@Override
	public String leggiRiga() {
		if(indiceIn < input.length)
			return input[indiceIn++];
		return null;
	}
	
	public String[] getOutput(){
		return this.output;
	}
	
	public int getNumeroOutput() {
		return this.indiceOut;
	}
}
