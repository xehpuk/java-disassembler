package de.xehpuk.disassembler.codes;

public abstract class LStoreAbstract extends IndexedInstruction {
	protected LStoreAbstract(final int index) {
		super(index);
	}

	public static LStoreAbstract getInstance(final int index) {
		switch (index) {
			case 0:
				return new LStore0();
			case 1:
				return new LStore1();
			case 2:
				return new LStore2();
			case 3:
				return new LStore3();
			default:
				return new LStore(index);
		}
	}
}