package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DCmpL implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DCMPL;
	}
}