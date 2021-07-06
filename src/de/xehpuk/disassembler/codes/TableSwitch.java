package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class TableSwitch implements Instruction { // TODO implement switch stuff
	@Override
	public OpCode getOpCode() {
		return OpCode.TABLESWITCH;
	}
}