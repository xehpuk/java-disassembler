package de.xehpuk.disassembler.codes;

public abstract class IndexedInstruction implements Instruction {
	private final int index;

	protected IndexedInstruction(final int index) {
		this.index = index;
	}

	public final int getIndex() {
		return index;
	}
}