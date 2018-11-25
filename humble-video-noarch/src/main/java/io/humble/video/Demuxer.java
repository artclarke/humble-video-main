/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.humble.video;
import io.humble.ferry.*;
/**
 * A Container that MediaPacket objects can be read from.
 */
public class Demuxer extends Container {
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  /**
   * This method is only here to use some references and remove
   * a Eclipse compiler warning.
   */
  @SuppressWarnings("unused")
  private void noop()
  {
    Buffer.make(null, 1);
  }
   
  private volatile long swigCPtr;

  /**
   * Internal Only.
   */
  protected Demuxer(long cPtr, boolean cMemoryOwn) {
    super(VideoJNI.Demuxer_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }
  
  /**
   * Internal Only.
   */
  protected Demuxer(long cPtr, boolean cMemoryOwn,
      java.util.concurrent.atomic.AtomicLong ref)
  {
    super(VideoJNI.Demuxer_SWIGUpcast(cPtr),
     cMemoryOwn, ref);
    swigCPtr = cPtr;
  }
    
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  protected static long getCPtr(Demuxer obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */  
  protected long getMyCPtr() {
    if (swigCPtr == 0) throw new IllegalStateException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Create a new Demuxer object that is actually referring to the
   * exact same underlying native object.
   *
   * @return the new Java object.
   */
  @Override
  public Demuxer copyReference() {
    if (swigCPtr == 0)
      return null;
    else
      return new Demuxer(swigCPtr, swigCMemOwn, getJavaRefCount());
  }

  /**
   * Compares two values, returning true if the underlying objects in native code are the same object.
   *
   * That means you can have two different Java objects, but when you do a comparison, you'll find out
   * they are the EXACT same object.
   *
   * @return True if the underlying native object is the same.  False otherwise.
   */
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof Demuxer)
      equal = (((Demuxer)obj).swigCPtr == this.swigCPtr);
    return equal;
  }
  
  /**
   * Get a hashable value for this object.
   *
   * @return the hashable value.
   */
  public int hashCode() {
     return (int)swigCPtr;
  }
  
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<
  // JNIHelper.swg: End generated code
  
  @Override
  public String toString() {
    final StringBuilder b = new StringBuilder(super.toString());
    b.append("[")
    .append("url="+getURL()+";")
    .append("format:"+getFormat()+";")
    .append("]");
    return b.toString();
  }

/**
 * Create a new Demuxer
 */
  public static Demuxer make() {
    long cPtr = VideoJNI.Demuxer_make();
    return (cPtr == 0) ? null : new Demuxer(cPtr, false);
  }

/**
 * Get the current state of the container.
 */
  public Demuxer.State getState() {
    return Demuxer.State.swigToEnum(VideoJNI.Demuxer_getState(swigCPtr, this));
  }

/**
 * Get the DemuxerFormat associated with this Demuxer<br>
 * or null if unknown.
 */
  public DemuxerFormat getFormat() {
    long cPtr = VideoJNI.Demuxer_getFormat(swigCPtr, this);
    return (cPtr == 0) ? null : new DemuxerFormat(cPtr, false);
  }

/**
 * Set the buffer length Humble Video will suggest to FFMPEG for reading inputs.<br>
 * <br>
 * If called when a Container is open, the call is ignored and -1 is returned.<br>
 * <br>
 * @param size The suggested buffer size.<br>
 * @throws InvalidArgument if size &lt;= 0
 */
  public void setInputBufferLength(int size) {
    VideoJNI.Demuxer_setInputBufferLength(swigCPtr, this, size);
  }

/**
 * Return the input buffer length.<br>
 * <br>
 * @return The input buffer length Humble Video told FFMPEG to assume.<br>
 *   0 means FFMPEG should choose it's own<br>
 *   size (and it'll probably be 32768).
 */
  public int getInputBufferLength() {
    return VideoJNI.Demuxer_getInputBufferLength(swigCPtr, this);
  }

/**
 * Open this container and make it ready for reading, optionally<br>
 * reading as far into the container as necessary to find all streams.<br>
 * <p>The caller must call #close() when done, but if not, the<br>
 * Demuxer will eventually close<br>
 * them later but warn to the logging system.<br>
 * <br>
 * @param url The resource to open; The format of this string is any<br>
 *   url that FFMPEG supports (including additional protocols if added<br>
 *   through the video.customio library).<br>
 * <br>
 * @param format A pointer to a InputFormat object specifying<br>
 *   the format of this container, or null if you want us to guess.<br>
 * @param streamsCanBeAddedDynamically If true, open() will expect that new<br>
 *   streams can be added at any time, even after the format header has been read.<br>
 * @param queryStreamMetaData If true, open() will call #queryStreamMetaData()<br>
 *   on this container, which will potentially block until it has ready<br>
 *   enough data to find all streams in a container.  If false, it will only<br>
 *   block to read a minimal header for this container format.<br>
 * @param options If not null, a set of key-value pairs that will be set on the container immediately<br>
 *   the format is determined.  Some options cannot be set on input formats until<br>
 *   the system has had a chance to determine what the format is, so this<br>
 *   is the only way to set InputFormat-specific options.<br>
 * @param optionsNotSet If not null, on return this KeyValueBag object will be cleared out, and<br>
 *   replaced with any key/value pairs that were in <code>options</code> but could not be set on this<br>
 *   Demuxer.
 */
  public void open(String url, DemuxerFormat format, boolean streamsCanBeAddedDynamically, boolean queryStreamMetaData, KeyValueBag options, KeyValueBag optionsNotSet) throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Demuxer_open(swigCPtr, this, url, DemuxerFormat.getCPtr(format), format, streamsCanBeAddedDynamically, queryStreamMetaData, KeyValueBag.getCPtr(options), options, KeyValueBag.getCPtr(optionsNotSet), optionsNotSet);
  }

/**
 * Close the container.  open() must have been called first, or<br>
 * else an error is returned.<br>
 * <p><br>
 * If this method exits because of an interruption,<br>
 * all resources will be closed anyway.<br>
 * </p>
 */
  public void close() throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Demuxer_close(swigCPtr, this);
  }

/**
 * Get the stream at the given position.<br>
 * <br>
 * @param streamIndex the index of this stream in the container<br>
 * @return The stream at that position in the container, or null if none there.
 */
  public DemuxerStream getStream(int streamIndex) throws java.lang.InterruptedException, java.io.IOException {
    long cPtr = VideoJNI.Demuxer_getStream(swigCPtr, this, streamIndex);
    return (cPtr == 0) ? null : new DemuxerStream(cPtr, false);
  }

/**
 * Reads the next packet in the Demuxer into the Packet.  This method will<br>
 * release any buffers currently held by this packet and allocate<br>
 * new ones.<br>
 * <p><br>
 * For non-blocking IO data sources, it is possible for this method<br>
 * to return as successful but with no complete packet. In that case<br>
 * the caller should retry again later (think EAGAIN) semantics.<br>
 * </p><br>
 * <br>
 * @param packet [In/Out] The packet the Demuxer will read into.<br>
 * <br>
 * @return 0 if successful, or &lt;0 if not.<br>
 * @throws RuntimeException if an error occurs except for EOF (in which case &lt;0 returned)<br>
 *         or EAGAIN (in which case 0 returned with an incomplete packet).
 */
  public int read(MediaPacket packet) throws java.lang.InterruptedException, java.io.IOException {
    return VideoJNI.Demuxer_read(swigCPtr, this, MediaPacket.getCPtr(packet), packet);
  }

/**
 * Attempts to read all the meta data in this stream, potentially by reading ahead<br>
 * and decoding packets.<br>
 * <p><br>
 * Any packets this method reads ahead will be cached and correctly returned when you<br>
 * read packets, but this method can be non-blocking potentially until end of container<br>
 * to get all meta data.  Take care when you call it.<br>
 * </p><p>After this method is called, other meta data methods like #getDuration() should<br>
 * work.</p>
 */
  public void queryStreamMetaData() throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Demuxer_queryStreamMetaData(swigCPtr, this);
  }

/**
 * Gets the duration, if known, of this container.<br>
 * <br>
 * This will only work for non-streamable containers where Demuxer<br>
 * can calculate the container size.<br>
 * <br>
 * @return The duration, or Global#NO_PTS if not known.
 */
  public long getDuration() {
    return VideoJNI.Demuxer_getDuration(swigCPtr, this);
  }

/**
 * Get the starting timestamp in microseconds of the first packet of the earliest stream in this container.<br>
 * <p><br>
 * This will only return value values either either (a) for non-streamable<br>
 * containers where Demuxer can calculate the container size or<br>
 * (b) after Demuxer has actually read the<br>
 * first packet from a streamable Demuxer.<br>
 * </p><br>
 * <br>
 * @return The starting timestamp in microseconds, or Global#NO_PTS if not known.
 */
  public long getStartTime() {
    return VideoJNI.Demuxer_getStartTime(swigCPtr, this);
  }

/**
 * Get the file size in bytes of this container.<br>
 * <br>
 * This will only return a valid value if the container is non-streamed and supports seek.<br>
 * <br>
 * @return The file size in bytes, or &lt;0 on error.
 */
  public long getFileSize() {
    return VideoJNI.Demuxer_getFileSize(swigCPtr, this);
  }

/**
 * Get the calculated overall bit rate of this file.<br>
 * <p><br>
 * This will only return a valid value if the container is non-streamed and supports seek.<br>
 * </p><br>
 * @return The overall bit rate in bytes per second, or &lt;0 on error.
 */
  public int getBitRate() {
    return VideoJNI.Demuxer_getBitRate(swigCPtr, this);
  }

/**
 * Get the flags associated with this object.<br>
 * <br>
 * @return The (compacted) value of all flags set.
 */
  public int getFlags() {
    return VideoJNI.Demuxer_getFlags(swigCPtr, this);
  }

/**
 * Set the flags to use with this object.  All values<br>
 * must be ORed (|) together.<br>
 * <br>
 * @see Flags<br>
 * <br>
 * @param newFlags The new set flags for this codec.
 */
  public void setFlags(int newFlags) {
    VideoJNI.Demuxer_setFlags(swigCPtr, this, newFlags);
  }

/**
 * Get the setting for the specified flag<br>
 * <br>
 * @param flag The flag you want to find the setting for<br>
 * <br>
 * @return 0 for false; non-zero for true
 */
  public boolean getFlag(Container.Flag flag) {
    return VideoJNI.Demuxer_getFlag(swigCPtr, this, flag.swigValue());
  }

/**
 * Set the flag.<br>
 * <br>
 * @param flag The flag to set<br>
 * @param value The value to set it to (true or false)
 */
  public void setFlag(Container.Flag flag, boolean value) {
    VideoJNI.Demuxer_setFlag(swigCPtr, this, flag.swigValue(), value);
  }

/**
 * Get the URL the Demuxer was opened with.<br>
 * May return null if unknown.<br>
 * @return the URL opened, or null.
 */
  public String getURL() {
    return VideoJNI.Demuxer_getURL(swigCPtr, this);
  }

/**
 * Get the number of times Demuxer#readNextPacket(Packet)<br>
 * will retry a read if it gets a Error.Type#ERROR_AGAIN<br>
 * value back.<br>
 * <br>
 * Defaults to 1 times.  &lt;0 means it will keep retrying indefinitely.<br>
 * <br>
 * @return the read retry count
 */
  public int getReadRetryCount() {
    return VideoJNI.Demuxer_getReadRetryCount(swigCPtr, this);
  }

/**
 * Sets the read retry count.<br>
 * <br>
 * @see #getReadRetryCount()<br>
 * <br>
 * @param count The read retry count.  &lt;0 means keep trying.
 */
  public void setReadRetryCount(int count) {
    VideoJNI.Demuxer_setReadRetryCount(swigCPtr, this, count);
  }

/**
 * Can streams be added dynamically to this container?<br>
 * <br>
 * @return true if streams can be added dynamically
 */
  public boolean canStreamsBeAddedDynamically() {
    return VideoJNI.Demuxer_canStreamsBeAddedDynamically(swigCPtr, this);
  }

/**
 * Get the KeyValueBag of media MetaData for this object,<br>
 * or null if none.<br>
 * <p><br>
 * If the Demuxer or IStream object<br>
 * that this KeyValueBag came from was opened<br>
 * for reading, then changes via KeyValueBag#setValue(String, String)<br>
 * will have no effect on the underlying media.<br>
 * </p><br>
 * <p><br>
 * If the Demuxer or IStream object<br>
 * that this KeyValueBag came from was opened<br>
 * for writing, then changes via KeyValueBag#setValue(String, String)<br>
 * will have no effect after Demuxer#writeHeader()<br>
 * is called.<br>
 * </p><br>
 * @return the KeyValueBag.
 */
  public KeyValueBag getMetaData() {
    long cPtr = VideoJNI.Demuxer_getMetaData(swigCPtr, this);
    return (cPtr == 0) ? null : new KeyValueBag(cPtr, false);
  }

/**
 * Forces the Demuxer to assume all audio streams are<br>
 * encoded with the given audio codec when demuxing.<br>
 * @param id The codec id<br>
 * @return &lt; 0 on error (e.g. not an audio codec); &gt;= 0 on success.
 */
  public int setForcedAudioCodec(Codec.ID id) {
    return VideoJNI.Demuxer_setForcedAudioCodec(swigCPtr, this, id.swigValue());
  }

/**
 * Forces the Demuxer to assume all video streams are<br>
 * encoded with the given video codec when demuxing.<br>
 * @param id The codec id<br>
 * @return &lt; 0 on error (e.g. not an video codec); &gt;= 0 on success.
 */
  public int setForcedVideoCodec(Codec.ID id) {
    return VideoJNI.Demuxer_setForcedVideoCodec(swigCPtr, this, id.swigValue());
  }

/**
 * Forces the Demuxer to assume all subtitle streams are<br>
 * encoded with the given subtitle codec when demuxing.<br>
 * @param id The codec id<br>
 * @return &lt; 0 on error (e.g. not an subtitle codec); &gt;= 0 on success.
 */
  public int setForcedSubtitleCodec(Codec.ID id) {
    return VideoJNI.Demuxer_setForcedSubtitleCodec(swigCPtr, this, id.swigValue());
  }

/**
 * Seek to timestamp ts.<br>
 * <br>
 * Seeking will be done so that the point from which all active streams<br>
 * can be presented successfully will be closest to ts and within min/max_ts.<br>
 * Active streams are all streams that have Stream.getDiscardSetting &lt;<br>
 * Codec.DISCARD_ALL.<br>
 * <br>
 * If flags contain SeekFlags.SEEK_BYTE, then all timestamps are in bytes and<br>
 * are the file position (this may not be supported by all demuxers).<br>
 * If flags contain SeekFlags.SEEK_FRAME, then all timestamps are in frames<br>
 * in the stream with stream_index (this may not be supported by all demuxers).<br>
 * Otherwise all timestamps are in units of the stream selected by stream_index<br>
 * or if stream_index is -1, in (1/Global.DEFAULT_PTS_MICROSECONDS} units.<br>
 * If flags contain SeekFlags.SEEK_ANY, then non-keyframes are treated as<br>
 * keyframes (this may not be supported by all demuxers).<br>
 * <br>
 * @param stream_index index of the stream which is used as time base reference<br>
 * @param min_ts smallest acceptable timestamp<br>
 * @param ts target timestamp<br>
 * @param max_ts largest acceptable timestamp<br>
 * @param flags flags<br>
 * @return &gt;=0 on success, error code otherwise<br>
 * <br>
 * Note: This is part of the new seek API which is still under construction.<br>
 *       Thus do not use this yet. It may change at any time, do not expect<br>
 *       ABI compatibility yet!
 */
  public int seek(int stream_index, long min_ts, long ts, long max_ts, int flags) throws java.lang.InterruptedException, java.io.IOException {
    return VideoJNI.Demuxer_seek(swigCPtr, this, stream_index, min_ts, ts, max_ts, flags);
  }

/**
 * Gets the AVFormatContext.max_delay property if possible.<br>
 * @return The max delay, error code otherwise.
 */
  public int getMaxDelay() {
    return VideoJNI.Demuxer_getMaxDelay(swigCPtr, this);
  }

/**
 * Start playing a network source. Call #pause() to pause.
 */
  public void play() throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Demuxer_play(swigCPtr, this);
  }

/**
 * Pause a playing network source. Call #play() to unpause.<br>
 * <br>
 * @return 0 on success; &lt;0 if state is not #State.STATE_PLAYING or error.
 */
  public void pause() throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Demuxer_pause(swigCPtr, this);
  }

  /**
   * Demuxers can only be in one of these states:
   */
  public enum State {
  /**
   * STATE_INITED: Allocated but open has not been called yet. Transitions to STATE_OPENED when ::open(...)<br>
   *   is successfully called, or STATE_ERROR if ::open(...) has an error.
   */
    STATE_INITED,
  /**
   * STATE_OPENED: Opened and read to read or write data. Transitions to STATE_CLOSED on successful ::close(...)<br>
   *   or STATE_ERROR if ::close(...) has an error.
   */
    STATE_OPENED,
  /**
   * Some Sources can be live (i.e. in Play mode)
   */
    STATE_PLAYING,
  /**
   * Some containers (e.g. networks) can be paused.
   */
    STATE_PAUSED,
  /**
   * STATE_CLOSED: Container is closed and should be discarded.
   */
    STATE_CLOSED,
  /**
   * STATE_ERROR: Container had an error and should be discarded.
   */
    STATE_ERROR,
  ;

    public final int swigValue() {
      return swigValue;
    }

    public static State swigToEnum(int swigValue) {
      State[] swigValues = State.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (State swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + State.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private State() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private State(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private State(State swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

  /**
   * Flags that can be bitmasked in the #seek method. If no<br>
   * flag, then key-frame-only/forward seeking is assumed.
   */
  public enum SeekFlag {
  /**
   * Seek backwards.
   */
    SEEK_BACKWARD(VideoJNI.Demuxer_SEEK_BACKWARD_get()),
  /**
   * Seek based on position in bytes. 
   */
    SEEK_BYTE(VideoJNI.Demuxer_SEEK_BYTE_get()),
  /**
   * Seek to any frame, even non-keyframes 
   */
    SEEK_ANY(VideoJNI.Demuxer_SEEK_ANY_get()),
  /**
   * Seek based on frame number 
   */
    SEEK_FRAME(VideoJNI.Demuxer_SEEK_FRAME_get()),
  ;

    public final int swigValue() {
      return swigValue;
    }

    public static SeekFlag swigToEnum(int swigValue) {
      SeekFlag[] swigValues = SeekFlag.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (SeekFlag swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + SeekFlag.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private SeekFlag() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private SeekFlag(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private SeekFlag(SeekFlag swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

}
