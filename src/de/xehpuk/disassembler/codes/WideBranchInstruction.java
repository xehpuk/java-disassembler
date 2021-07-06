package de.xehpuk.disassembler.codes;

public abstract class WideBranchInstruction implements Instruction {
	private final int offset;

	protected WideBranchInstruction(final int offset) {
		this.offset = offset;
	}

	public final int getOffset() {
		return offset;
	}
}