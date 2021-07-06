package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DLoad2 extends DLoadAbstract {
	protected DLoad2() {
		super(2);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.DLOAD_2;
	}
}