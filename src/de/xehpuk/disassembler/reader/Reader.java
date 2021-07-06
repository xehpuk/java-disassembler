package de.xehpuk.disassembler.reader;

import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;

/**
 *
 * @author xehpuk
 */
public abstract class Reader<T> implements DataInput {
	private final DataInput in;

	public Reader(final DataInput in) {
		this.in = in;
	}

	public abstract T read() throws IOException;

	@Override
	public void readFully(final byte[] b) throws IOException {
		in.readFully(b);
	}

	@Override
	public void readFully(final byte[] b, final int off, final int len) throws IOException {
		in.readFully(b, off, len);
	}

	@Override
	public int skipBytes(final int n) throws IOException {
		return in.skipBytes(n);
	}

	public void skipFully(final int n) throws IOException {
		final int skipped = skipBytes(n);
		if (skipped != n) {
			throw new EOFException("skipped " + skipped + " instead of " + n);
		}
	}

	public long skipBytes(final long n) throws IOException {
		long skip = n, skipped = 0;
		do {
			final int min = (int) Math.min(Integer.MAX_VALUE, skip);
			skipped += skipBytes(min);
			skip -= min;
		} while (skip > 0);
		return skipped;
	}

	public void skipFully(final long n) throws IOException {
		final long skipped = skipBytes(n);
		if (skipped != n) {
			throw new EOFException("skipped " + skipped + " instead of " + n);
		}
	}

	@Override
	public boolean readBoolean() throws IOException {
		return in.readBoolean();
	}

	@Override
	public byte readByte() throws IOException {
		return in.readByte();
	}

	@Override
	public int readUnsignedByte() throws IOException {
		return in.readUnsignedByte();
	}

	@Override
	public short readShort() throws IOException {
		return in.readShort();
	}

	@Override
	public int readUnsignedShort() throws IOException {
		return in.readUnsignedShort();
	}

	@Override
	public char readChar() throws IOException {
		return in.readChar();
	}

	@Override
	public int readInt() throws IOException {
		return in.readInt();
	}

	public long readUnsignedInt() throws IOException {
		return in.readInt() & 0xFFFF_FFFFL;
	}

	@Override
	public long readLong() throws IOException {
		return in.readLong();
	}

	@Override
	public float readFloat() throws IOException {
		return in.readFloat();
	}

	@Override
	public double readDouble() throws IOException {
		return in.readDouble();
	}

	@Override
	public String readLine() throws IOException {
		return in.readLine();
	}

	@Override
	public String readUTF() throws IOException {
		return in.readUTF();
	}
}