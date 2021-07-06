package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class MonitorEnter implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.MONITORENTER;
	}
}