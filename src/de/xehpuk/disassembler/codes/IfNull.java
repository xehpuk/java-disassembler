package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfNull extends BranchInstruction {
	public IfNull(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IFNULL;
	}
}