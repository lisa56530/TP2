package ticketmachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@BeforeEach
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation.
	void priceIsCorrectlyInitialized() {
		// Paramètres : valeur attendue, valeur effective, message si erreur
		assertEquals(PRICE, machine.getPrice(), "Initialisation incorrecte du prix");
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
                // Les montants ont été correctement additionnés  
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour");              
	}
	
	@Test
	void pasImprimerSiSuffiant () {
		machine.insertMoney (PRICE -1);
		assertFalse(machine.printTicket(), "le ticket ne doit pas s'imprimer") ;
	}
	@Test
	void imprimerSiSuffisant () {
	machine.insertMoney (PRICE);

	assertTrue(machine.printTicket() , "le ticket doit s'imprimer" )	; 
	}
	
@Test
	void decrementer () {
	machine.insertMoney (PRICE);
	machine.printTicket () ; 
	assertTrue ( machine.getBalance () == 0 ,  "la balance est décrémenter du ticket") ; 
}

@Test
	void miseJour () {
	machine.insertMoney (PRICE);
	machine.printTicket () ; 
	assertEquals ( machine.getBalance () , 0 , "mise a jour effectuée") ; 
}


@Test
	void refund  () {
	machine.insertMoney (PRICE);
	machine.printTicket () ; 
	
	assertEquals ( machine.getTotal (),  PRICE , "mise a jour effectuée") ; 
}


void refund2 () {
	machine.insertMoney (PRICE);
	machine.printTicket () ; 
	
	assertEquals ( machine.getTotal () ==0, 0  , "mise a jour effectuée") ; 
}


@Test
	void negatif () {
	machine.insertMoney (PRICE -60 );	
	assertFalse (machine. getBalance )
 }

@TesT
	void cantInsertNegativeMoney(){
		assertThrows(IllegalArgumentException.class, () -> {machine.insertMoney(-10);},  "La machine ne doit pas recevoir des montants négatifs");
	}

@Test
	void cantCreateTicketMachineWithNegativePrice(){
		assertThrows(IllegalArgumentException.class, () -> {new TicketMachine(-1);}, "");
	}
}
	
