package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfNonNull extends BranchInstruction {
	public IfNonNull(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IFNONNULL;
	}
}