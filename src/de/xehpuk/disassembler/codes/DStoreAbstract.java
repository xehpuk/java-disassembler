package de.xehpuk.disassembler.codes;

public abstract class DStoreAbstract extends IndexedInstruction {
	protected DStoreAbstract(final int index) {
		super(index);
	}

	public static DStoreAbstract getInstance(final int index) {
		switch (index) {
			case 0:
				return new DStore0();
			case 1:
				return new DStore1();
			case 2:
				return new DStore2();
			case 3:
				return new DStore3();
			default:
				return new DStore(index);
		}
	}
}