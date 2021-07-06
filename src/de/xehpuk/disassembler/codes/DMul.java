package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DMul implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DMUL;
	}
}