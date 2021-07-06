package de.xehpuk.disassembler.codes;

public abstract class BranchInstruction implements Instruction {
	private final short offset;

	protected BranchInstruction(final short offset) {
		this.offset = offset;
	}

	public final short getOffset() {
		return offset;
	}
}