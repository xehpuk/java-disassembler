package de.xehpuk.disassembler.codes;

public abstract class Wide extends IndexedInstruction {
	private final OpCode code;

	public Wide(final int index, final OpCode code) {
		super(index);
		this.code = code;
	}

	public final OpCode getCode() {
		return code;
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.WIDE;
	}
}
