package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class Return implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.RETURN;
	}
}