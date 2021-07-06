package de.xehpuk.disassembler.codes;

public abstract class AStoreAbstract extends IndexedInstruction {
	protected AStoreAbstract(final int index) {
		super(index);
	}

	public static AStoreAbstract getInstance(final int index) {
		switch (index) {
			case 0:
				return new AStore0();
			case 1:
				return new AStore1();
			case 2:
				return new AStore2();
			case 3:
				return new AStore3();
			default:
				return new AStore(index);
		}
	}
}