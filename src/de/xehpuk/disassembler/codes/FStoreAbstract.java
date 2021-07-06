package de.xehpuk.disassembler.codes;

public abstract class FStoreAbstract extends IndexedInstruction {
	protected FStoreAbstract(final int index) {
		super(index);
	}

	public static FStoreAbstract getInstance(final int index) {
		switch (index) {
			case 0:
				return new FStore0();
			case 1:
				return new FStore1();
			case 2:
				return new FStore2();
			case 3:
				return new FStore3();
			default:
				return new FStore(index);
		}
	}
}