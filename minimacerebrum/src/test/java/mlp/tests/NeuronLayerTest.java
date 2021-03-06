package mlp.tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mlp.Neuron;
import mlp.NeuronLayer;

public class NeuronLayerTest {
	private NeuronLayer sut;
	@BeforeEach
	void init() {
		sut = new NeuronLayer();
	}
	
	@Test
	void testingLayerNeuronAddGet() {
		Neuron n = new Neuron(); 
		n.setId(1);
		sut.addNeuron(n);
		int actual = sut.getNeuron(0).getId();
		int expectedId = 1;
		assertEquals(expectedId,actual);
	}
	
	@Test
	void testingLayerSize() {
		sut.addNeuron(new Neuron());
		sut.addNeuron(new Neuron());
		sut.addNeuron(new Neuron());
		sut.addNeuron(new Neuron());
		sut.addNeuron(new Neuron());
		int actualNet = sut.size();
		int expectedNet = 5;
		assertEquals(expectedNet,actualNet);
	}
	
	@Test
	void testingLayerSizeEmpty() {
		int actualNet = sut.size();
		int expectedNet = 0;
		assertEquals(expectedNet,actualNet);
	}
	
	@Test
	void testingPrapagationFunction() {
		Neuron n = new Neuron();
		n.setOutput(1.0f);
		n.setWeight(0,1);
		Neuron n2 = new Neuron();
		n2.setOutput(1.0f);
		n2.setWeight(0,1);
		Neuron n3 = new Neuron();
		n3.setOutput(1.0f);
		n3.setWeight(0,1);
		Neuron n4 = new Neuron();
		n4.setOutput(1.0f);
		n4.setWeight(0,1);
		Neuron n5 = new Neuron();
		n5.setOutput(1.0f);
		n5.setWeight(0,1);
		
		sut.addNeuron(n);
		sut.addNeuron(n2);
		sut.addNeuron(n3);
		sut.addNeuron(n4);
		sut.addNeuron(n5);
		float actualNet = sut.propagate(0);
		float expectedNet =5.0f;
		assertTrue(Float.compare(expectedNet,actualNet) == 0);
	}
	
	@Test
	void testingPrapagationFunctionT2() {
		Neuron n = new Neuron();
		n.setOutput(2.0f);
		n.setWeight(0,1);
		Neuron n2 = new Neuron();
		n2.setOutput(2.0f);
		n2.setWeight(0,1);
		Neuron n3 = new Neuron();
		n3.setOutput(2.0f);
		n3.setWeight(0,1);
		Neuron n4 = new Neuron();
		n4.setOutput(2.0f);
		n4.setWeight(0,1);
		Neuron n5 = new Neuron();
		n5.setOutput(2.0f);
		n5.setWeight(0,1);
		
		sut.addNeuron(n);
		sut.addNeuron(n2);
		sut.addNeuron(n3);
		sut.addNeuron(n4);
		sut.addNeuron(n5);
		float actualNet = sut.propagate(0);
		float expectedNet =10.0f;
		assertTrue(Float.compare(expectedNet,actualNet) == 0);
	}
	
	@Test
	void testingPrapagationFunctionNegativesT3() {
		Neuron n = new Neuron();
		n.setOutput(2.0f);
		n.setWeight(0,-1);
		Neuron n2 = new Neuron();
		n2.setOutput(2.0f);
		n2.setWeight(0,-1);
		Neuron n3 = new Neuron();
		n3.setOutput(2.0f);
		n3.setWeight(0,-1);
		Neuron n4 = new Neuron();
		n4.setOutput(2.0f);
		n4.setWeight(0,-1);
		Neuron n5 = new Neuron();
		n5.setOutput(2.0f);
		n5.setWeight(1,-1);
		n5.setWeight(0,-1);
		
		sut.addNeuron(n);
		sut.addNeuron(n2);
		sut.addNeuron(n3);
		sut.addNeuron(n4);
		sut.addNeuron(n5);
		float actualNet = sut.propagate(0);
		float expectedNet =-10.0f;
		assertTrue(Float.compare(expectedNet,actualNet) == 0);
	}
	
	@Test
	void testingInitiationOfLayer() {
		Neuron n = new Neuron();
		n.setOutput(2.0f);
		n.setWeight(0,-1);
		Neuron n2 = new Neuron();
		n2.setOutput(2.0f);
		n2.setWeight(0,-1);
		Neuron n3 = new Neuron();
		n3.setOutput(2.0f);
		n3.setWeight(0,-1);
		Neuron n4 = new Neuron();
		n4.setOutput(2.0f);
		n4.setWeight(0,-1);
		Neuron n5 = new Neuron();
		n5.setOutput(2.0f);
		n5.setWeight(1,-1);
		n5.setWeight(0,-1);
		
		sut.addNeuron(n);
		sut.addNeuron(n2);
		sut.addNeuron(n3);
		sut.addNeuron(n4);
		sut.addNeuron(n5);
		float actualNet = sut.propagate(0);
		float expectedNet =-10.0f;
		assertTrue(Float.compare(expectedNet,actualNet) == 0);
	}
	
}
