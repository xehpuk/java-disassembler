package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LookupSwitch implements Instruction { // TODO implement switch stuff
	@Override
	public OpCode getOpCode() {
		return OpCode.LOOKUPSWITCH;
	}
}