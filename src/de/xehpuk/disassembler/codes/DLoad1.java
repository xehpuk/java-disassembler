package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DLoad1 extends DLoadAbstract {
	protected DLoad1() {
		super(1);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.DLOAD_1;
	}
}