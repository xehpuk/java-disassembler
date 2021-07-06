package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FCmpL implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.FCMPL;
	}
}