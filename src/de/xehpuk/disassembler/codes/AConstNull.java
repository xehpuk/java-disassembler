package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public enum AConstNull implements Instruction {
	INSTANCE;
	
	@Override
	public OpCode getOpCode() {
		return OpCode.ACONST_NULL;
	}
}