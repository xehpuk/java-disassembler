package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class AStore0 extends AStoreAbstract {
	protected AStore0() {
		super(0);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ASTORE_0;
	}
}