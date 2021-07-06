package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DLoad0 extends DLoadAbstract {
	protected DLoad0() {
		super(0);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.DLOAD_0;
	}
}