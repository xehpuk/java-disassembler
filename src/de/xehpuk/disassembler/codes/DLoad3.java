package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DLoad3 extends DLoadAbstract {
	protected DLoad3() {
		super(3);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.DLOAD_3;
	}
}