/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.beanit.asn1bean.compiler.rspdefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.asn1bean.ber.*;
import com.beanit.asn1bean.ber.types.*;
import com.beanit.asn1bean.ber.types.string.*;

import com.beanit.asn1bean.compiler.pkix1explicit88.Certificate;
import com.beanit.asn1bean.compiler.pkix1explicit88.CertificateList;
import com.beanit.asn1bean.compiler.pkix1explicit88.Time;
import com.beanit.asn1bean.compiler.pkix1implicit88.SubjectKeyIdentifier;

public class CancelSessionRequest implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 65);

	private byte[] code = null;
	public TransactionId transactionId = null;
	public CancelSessionReason reason = null;
	
	public CancelSessionRequest() {
	}

	public CancelSessionRequest(byte[] code) {
		this.code = code;
	}

	public CancelSessionRequest(TransactionId transactionId, CancelSessionReason reason) {
		this.transactionId = transactionId;
		this.reason = reason;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += reason.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 1
		reverseOS.write(0x81);
		codeLength += 1;
		
		codeLength += transactionId.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 0
		reverseOS.write(0x80);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlByteCount = 0;
		int vByteCount = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			transactionId = new TransactionId();
			vByteCount += transactionId.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			reason = new CancelSessionReason();
			vByteCount += reason.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (lengthVal < 0) {
			while (!berTag.equals(0, 0, 0)) {
				vByteCount += DecodeUtil.decodeUnknownComponent(is);
				vByteCount += berTag.decode(is);
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
		} else {
			while (vByteCount < lengthVal) {
				vByteCount += DecodeUtil.decodeUnknownComponent(is);
				if (vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (transactionId != null) {
			sb.append("transactionId: ").append(transactionId);
		}
		else {
			sb.append("transactionId: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (reason != null) {
			sb.append("reason: ").append(reason);
		}
		else {
			sb.append("reason: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

