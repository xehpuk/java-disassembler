package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class MonitorExit implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.MONITOREXIT;
	}
}