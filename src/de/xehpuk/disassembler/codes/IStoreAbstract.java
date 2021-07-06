package de.xehpuk.disassembler.codes;

public abstract class IStoreAbstract extends IndexedInstruction {
	protected IStoreAbstract(final int index) {
		super(index);
	}

	public static IStoreAbstract getInstance(final int index) {
		switch (index) {
			case 0:
				return new IStore0();
			case 1:
				return new IStore1();
			case 2:
				return new IStore2();
			case 3:
				return new IStore3();
			default:
				return new IStore(index);
		}
	}
}