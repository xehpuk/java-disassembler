package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IShR implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.ISHR;
	}
}