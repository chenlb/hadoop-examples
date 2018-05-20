/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.apache.hadoop.mapreduce.jobhistory;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class JobSubmitted extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1250025821861670902L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"JobSubmitted\",\"namespace\":\"org.apache.hadoop.mapreduce.jobhistory\",\"fields\":[{\"name\":\"jobid\",\"type\":\"string\"},{\"name\":\"jobName\",\"type\":\"string\"},{\"name\":\"userName\",\"type\":\"string\"},{\"name\":\"submitTime\",\"type\":\"long\"},{\"name\":\"jobConfPath\",\"type\":\"string\"},{\"name\":\"acls\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"jobQueueName\",\"type\":\"string\"},{\"name\":\"workflowId\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"workflowName\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"workflowNodeName\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"workflowAdjacencies\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"workflowTags\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<JobSubmitted> ENCODER =
      new BinaryMessageEncoder<JobSubmitted>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<JobSubmitted> DECODER =
      new BinaryMessageDecoder<JobSubmitted>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<JobSubmitted> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<JobSubmitted> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<JobSubmitted>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this JobSubmitted to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a JobSubmitted from a ByteBuffer. */
  public static JobSubmitted fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence jobid;
  @Deprecated public java.lang.CharSequence jobName;
  @Deprecated public java.lang.CharSequence userName;
  @Deprecated public long submitTime;
  @Deprecated public java.lang.CharSequence jobConfPath;
  @Deprecated public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> acls;
  @Deprecated public java.lang.CharSequence jobQueueName;
  @Deprecated public java.lang.CharSequence workflowId;
  @Deprecated public java.lang.CharSequence workflowName;
  @Deprecated public java.lang.CharSequence workflowNodeName;
  @Deprecated public java.lang.CharSequence workflowAdjacencies;
  @Deprecated public java.lang.CharSequence workflowTags;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public JobSubmitted() {}

  /**
   * All-args constructor.
   * @param jobid The new value for jobid
   * @param jobName The new value for jobName
   * @param userName The new value for userName
   * @param submitTime The new value for submitTime
   * @param jobConfPath The new value for jobConfPath
   * @param acls The new value for acls
   * @param jobQueueName The new value for jobQueueName
   * @param workflowId The new value for workflowId
   * @param workflowName The new value for workflowName
   * @param workflowNodeName The new value for workflowNodeName
   * @param workflowAdjacencies The new value for workflowAdjacencies
   * @param workflowTags The new value for workflowTags
   */
  public JobSubmitted(java.lang.CharSequence jobid, java.lang.CharSequence jobName, java.lang.CharSequence userName, java.lang.Long submitTime, java.lang.CharSequence jobConfPath, java.util.Map<java.lang.CharSequence,java.lang.CharSequence> acls, java.lang.CharSequence jobQueueName, java.lang.CharSequence workflowId, java.lang.CharSequence workflowName, java.lang.CharSequence workflowNodeName, java.lang.CharSequence workflowAdjacencies, java.lang.CharSequence workflowTags) {
    this.jobid = jobid;
    this.jobName = jobName;
    this.userName = userName;
    this.submitTime = submitTime;
    this.jobConfPath = jobConfPath;
    this.acls = acls;
    this.jobQueueName = jobQueueName;
    this.workflowId = workflowId;
    this.workflowName = workflowName;
    this.workflowNodeName = workflowNodeName;
    this.workflowAdjacencies = workflowAdjacencies;
    this.workflowTags = workflowTags;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return jobid;
    case 1: return jobName;
    case 2: return userName;
    case 3: return submitTime;
    case 4: return jobConfPath;
    case 5: return acls;
    case 6: return jobQueueName;
    case 7: return workflowId;
    case 8: return workflowName;
    case 9: return workflowNodeName;
    case 10: return workflowAdjacencies;
    case 11: return workflowTags;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: jobid = (java.lang.CharSequence)value$; break;
    case 1: jobName = (java.lang.CharSequence)value$; break;
    case 2: userName = (java.lang.CharSequence)value$; break;
    case 3: submitTime = (java.lang.Long)value$; break;
    case 4: jobConfPath = (java.lang.CharSequence)value$; break;
    case 5: acls = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>)value$; break;
    case 6: jobQueueName = (java.lang.CharSequence)value$; break;
    case 7: workflowId = (java.lang.CharSequence)value$; break;
    case 8: workflowName = (java.lang.CharSequence)value$; break;
    case 9: workflowNodeName = (java.lang.CharSequence)value$; break;
    case 10: workflowAdjacencies = (java.lang.CharSequence)value$; break;
    case 11: workflowTags = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'jobid' field.
   * @return The value of the 'jobid' field.
   */
  public java.lang.CharSequence getJobid() {
    return jobid;
  }

  /**
   * Sets the value of the 'jobid' field.
   * @param value the value to set.
   */
  public void setJobid(java.lang.CharSequence value) {
    this.jobid = value;
  }

  /**
   * Gets the value of the 'jobName' field.
   * @return The value of the 'jobName' field.
   */
  public java.lang.CharSequence getJobName() {
    return jobName;
  }

  /**
   * Sets the value of the 'jobName' field.
   * @param value the value to set.
   */
  public void setJobName(java.lang.CharSequence value) {
    this.jobName = value;
  }

  /**
   * Gets the value of the 'userName' field.
   * @return The value of the 'userName' field.
   */
  public java.lang.CharSequence getUserName() {
    return userName;
  }

  /**
   * Sets the value of the 'userName' field.
   * @param value the value to set.
   */
  public void setUserName(java.lang.CharSequence value) {
    this.userName = value;
  }

  /**
   * Gets the value of the 'submitTime' field.
   * @return The value of the 'submitTime' field.
   */
  public java.lang.Long getSubmitTime() {
    return submitTime;
  }

  /**
   * Sets the value of the 'submitTime' field.
   * @param value the value to set.
   */
  public void setSubmitTime(java.lang.Long value) {
    this.submitTime = value;
  }

  /**
   * Gets the value of the 'jobConfPath' field.
   * @return The value of the 'jobConfPath' field.
   */
  public java.lang.CharSequence getJobConfPath() {
    return jobConfPath;
  }

  /**
   * Sets the value of the 'jobConfPath' field.
   * @param value the value to set.
   */
  public void setJobConfPath(java.lang.CharSequence value) {
    this.jobConfPath = value;
  }

  /**
   * Gets the value of the 'acls' field.
   * @return The value of the 'acls' field.
   */
  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getAcls() {
    return acls;
  }

  /**
   * Sets the value of the 'acls' field.
   * @param value the value to set.
   */
  public void setAcls(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
    this.acls = value;
  }

  /**
   * Gets the value of the 'jobQueueName' field.
   * @return The value of the 'jobQueueName' field.
   */
  public java.lang.CharSequence getJobQueueName() {
    return jobQueueName;
  }

  /**
   * Sets the value of the 'jobQueueName' field.
   * @param value the value to set.
   */
  public void setJobQueueName(java.lang.CharSequence value) {
    this.jobQueueName = value;
  }

  /**
   * Gets the value of the 'workflowId' field.
   * @return The value of the 'workflowId' field.
   */
  public java.lang.CharSequence getWorkflowId() {
    return workflowId;
  }

  /**
   * Sets the value of the 'workflowId' field.
   * @param value the value to set.
   */
  public void setWorkflowId(java.lang.CharSequence value) {
    this.workflowId = value;
  }

  /**
   * Gets the value of the 'workflowName' field.
   * @return The value of the 'workflowName' field.
   */
  public java.lang.CharSequence getWorkflowName() {
    return workflowName;
  }

  /**
   * Sets the value of the 'workflowName' field.
   * @param value the value to set.
   */
  public void setWorkflowName(java.lang.CharSequence value) {
    this.workflowName = value;
  }

  /**
   * Gets the value of the 'workflowNodeName' field.
   * @return The value of the 'workflowNodeName' field.
   */
  public java.lang.CharSequence getWorkflowNodeName() {
    return workflowNodeName;
  }

  /**
   * Sets the value of the 'workflowNodeName' field.
   * @param value the value to set.
   */
  public void setWorkflowNodeName(java.lang.CharSequence value) {
    this.workflowNodeName = value;
  }

  /**
   * Gets the value of the 'workflowAdjacencies' field.
   * @return The value of the 'workflowAdjacencies' field.
   */
  public java.lang.CharSequence getWorkflowAdjacencies() {
    return workflowAdjacencies;
  }

  /**
   * Sets the value of the 'workflowAdjacencies' field.
   * @param value the value to set.
   */
  public void setWorkflowAdjacencies(java.lang.CharSequence value) {
    this.workflowAdjacencies = value;
  }

  /**
   * Gets the value of the 'workflowTags' field.
   * @return The value of the 'workflowTags' field.
   */
  public java.lang.CharSequence getWorkflowTags() {
    return workflowTags;
  }

  /**
   * Sets the value of the 'workflowTags' field.
   * @param value the value to set.
   */
  public void setWorkflowTags(java.lang.CharSequence value) {
    this.workflowTags = value;
  }

  /**
   * Creates a new JobSubmitted RecordBuilder.
   * @return A new JobSubmitted RecordBuilder
   */
  public static org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder newBuilder() {
    return new org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder();
  }

  /**
   * Creates a new JobSubmitted RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new JobSubmitted RecordBuilder
   */
  public static org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder newBuilder(org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder other) {
    return new org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder(other);
  }

  /**
   * Creates a new JobSubmitted RecordBuilder by copying an existing JobSubmitted instance.
   * @param other The existing instance to copy.
   * @return A new JobSubmitted RecordBuilder
   */
  public static org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder newBuilder(org.apache.hadoop.mapreduce.jobhistory.JobSubmitted other) {
    return new org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder(other);
  }

  /**
   * RecordBuilder for JobSubmitted instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<JobSubmitted>
    implements org.apache.avro.data.RecordBuilder<JobSubmitted> {

    private java.lang.CharSequence jobid;
    private java.lang.CharSequence jobName;
    private java.lang.CharSequence userName;
    private long submitTime;
    private java.lang.CharSequence jobConfPath;
    private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> acls;
    private java.lang.CharSequence jobQueueName;
    private java.lang.CharSequence workflowId;
    private java.lang.CharSequence workflowName;
    private java.lang.CharSequence workflowNodeName;
    private java.lang.CharSequence workflowAdjacencies;
    private java.lang.CharSequence workflowTags;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.jobid)) {
        this.jobid = data().deepCopy(fields()[0].schema(), other.jobid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.jobName)) {
        this.jobName = data().deepCopy(fields()[1].schema(), other.jobName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.userName)) {
        this.userName = data().deepCopy(fields()[2].schema(), other.userName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.submitTime)) {
        this.submitTime = data().deepCopy(fields()[3].schema(), other.submitTime);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.jobConfPath)) {
        this.jobConfPath = data().deepCopy(fields()[4].schema(), other.jobConfPath);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.acls)) {
        this.acls = data().deepCopy(fields()[5].schema(), other.acls);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.jobQueueName)) {
        this.jobQueueName = data().deepCopy(fields()[6].schema(), other.jobQueueName);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.workflowId)) {
        this.workflowId = data().deepCopy(fields()[7].schema(), other.workflowId);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.workflowName)) {
        this.workflowName = data().deepCopy(fields()[8].schema(), other.workflowName);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.workflowNodeName)) {
        this.workflowNodeName = data().deepCopy(fields()[9].schema(), other.workflowNodeName);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.workflowAdjacencies)) {
        this.workflowAdjacencies = data().deepCopy(fields()[10].schema(), other.workflowAdjacencies);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.workflowTags)) {
        this.workflowTags = data().deepCopy(fields()[11].schema(), other.workflowTags);
        fieldSetFlags()[11] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing JobSubmitted instance
     * @param other The existing instance to copy.
     */
    private Builder(org.apache.hadoop.mapreduce.jobhistory.JobSubmitted other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.jobid)) {
        this.jobid = data().deepCopy(fields()[0].schema(), other.jobid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.jobName)) {
        this.jobName = data().deepCopy(fields()[1].schema(), other.jobName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.userName)) {
        this.userName = data().deepCopy(fields()[2].schema(), other.userName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.submitTime)) {
        this.submitTime = data().deepCopy(fields()[3].schema(), other.submitTime);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.jobConfPath)) {
        this.jobConfPath = data().deepCopy(fields()[4].schema(), other.jobConfPath);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.acls)) {
        this.acls = data().deepCopy(fields()[5].schema(), other.acls);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.jobQueueName)) {
        this.jobQueueName = data().deepCopy(fields()[6].schema(), other.jobQueueName);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.workflowId)) {
        this.workflowId = data().deepCopy(fields()[7].schema(), other.workflowId);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.workflowName)) {
        this.workflowName = data().deepCopy(fields()[8].schema(), other.workflowName);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.workflowNodeName)) {
        this.workflowNodeName = data().deepCopy(fields()[9].schema(), other.workflowNodeName);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.workflowAdjacencies)) {
        this.workflowAdjacencies = data().deepCopy(fields()[10].schema(), other.workflowAdjacencies);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.workflowTags)) {
        this.workflowTags = data().deepCopy(fields()[11].schema(), other.workflowTags);
        fieldSetFlags()[11] = true;
      }
    }

    /**
      * Gets the value of the 'jobid' field.
      * @return The value.
      */
    public java.lang.CharSequence getJobid() {
      return jobid;
    }

    /**
      * Sets the value of the 'jobid' field.
      * @param value The value of 'jobid'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setJobid(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.jobid = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'jobid' field has been set.
      * @return True if the 'jobid' field has been set, false otherwise.
      */
    public boolean hasJobid() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'jobid' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearJobid() {
      jobid = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'jobName' field.
      * @return The value.
      */
    public java.lang.CharSequence getJobName() {
      return jobName;
    }

    /**
      * Sets the value of the 'jobName' field.
      * @param value The value of 'jobName'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setJobName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.jobName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'jobName' field has been set.
      * @return True if the 'jobName' field has been set, false otherwise.
      */
    public boolean hasJobName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'jobName' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearJobName() {
      jobName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'userName' field.
      * @return The value.
      */
    public java.lang.CharSequence getUserName() {
      return userName;
    }

    /**
      * Sets the value of the 'userName' field.
      * @param value The value of 'userName'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setUserName(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.userName = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'userName' field has been set.
      * @return True if the 'userName' field has been set, false otherwise.
      */
    public boolean hasUserName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'userName' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearUserName() {
      userName = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'submitTime' field.
      * @return The value.
      */
    public java.lang.Long getSubmitTime() {
      return submitTime;
    }

    /**
      * Sets the value of the 'submitTime' field.
      * @param value The value of 'submitTime'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setSubmitTime(long value) {
      validate(fields()[3], value);
      this.submitTime = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'submitTime' field has been set.
      * @return True if the 'submitTime' field has been set, false otherwise.
      */
    public boolean hasSubmitTime() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'submitTime' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearSubmitTime() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'jobConfPath' field.
      * @return The value.
      */
    public java.lang.CharSequence getJobConfPath() {
      return jobConfPath;
    }

    /**
      * Sets the value of the 'jobConfPath' field.
      * @param value The value of 'jobConfPath'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setJobConfPath(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.jobConfPath = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'jobConfPath' field has been set.
      * @return True if the 'jobConfPath' field has been set, false otherwise.
      */
    public boolean hasJobConfPath() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'jobConfPath' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearJobConfPath() {
      jobConfPath = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'acls' field.
      * @return The value.
      */
    public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getAcls() {
      return acls;
    }

    /**
      * Sets the value of the 'acls' field.
      * @param value The value of 'acls'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setAcls(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
      validate(fields()[5], value);
      this.acls = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'acls' field has been set.
      * @return True if the 'acls' field has been set, false otherwise.
      */
    public boolean hasAcls() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'acls' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearAcls() {
      acls = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'jobQueueName' field.
      * @return The value.
      */
    public java.lang.CharSequence getJobQueueName() {
      return jobQueueName;
    }

    /**
      * Sets the value of the 'jobQueueName' field.
      * @param value The value of 'jobQueueName'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setJobQueueName(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.jobQueueName = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'jobQueueName' field has been set.
      * @return True if the 'jobQueueName' field has been set, false otherwise.
      */
    public boolean hasJobQueueName() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'jobQueueName' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearJobQueueName() {
      jobQueueName = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'workflowId' field.
      * @return The value.
      */
    public java.lang.CharSequence getWorkflowId() {
      return workflowId;
    }

    /**
      * Sets the value of the 'workflowId' field.
      * @param value The value of 'workflowId'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setWorkflowId(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.workflowId = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'workflowId' field has been set.
      * @return True if the 'workflowId' field has been set, false otherwise.
      */
    public boolean hasWorkflowId() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'workflowId' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearWorkflowId() {
      workflowId = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'workflowName' field.
      * @return The value.
      */
    public java.lang.CharSequence getWorkflowName() {
      return workflowName;
    }

    /**
      * Sets the value of the 'workflowName' field.
      * @param value The value of 'workflowName'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setWorkflowName(java.lang.CharSequence value) {
      validate(fields()[8], value);
      this.workflowName = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'workflowName' field has been set.
      * @return True if the 'workflowName' field has been set, false otherwise.
      */
    public boolean hasWorkflowName() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'workflowName' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearWorkflowName() {
      workflowName = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'workflowNodeName' field.
      * @return The value.
      */
    public java.lang.CharSequence getWorkflowNodeName() {
      return workflowNodeName;
    }

    /**
      * Sets the value of the 'workflowNodeName' field.
      * @param value The value of 'workflowNodeName'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setWorkflowNodeName(java.lang.CharSequence value) {
      validate(fields()[9], value);
      this.workflowNodeName = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'workflowNodeName' field has been set.
      * @return True if the 'workflowNodeName' field has been set, false otherwise.
      */
    public boolean hasWorkflowNodeName() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'workflowNodeName' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearWorkflowNodeName() {
      workflowNodeName = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'workflowAdjacencies' field.
      * @return The value.
      */
    public java.lang.CharSequence getWorkflowAdjacencies() {
      return workflowAdjacencies;
    }

    /**
      * Sets the value of the 'workflowAdjacencies' field.
      * @param value The value of 'workflowAdjacencies'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setWorkflowAdjacencies(java.lang.CharSequence value) {
      validate(fields()[10], value);
      this.workflowAdjacencies = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'workflowAdjacencies' field has been set.
      * @return True if the 'workflowAdjacencies' field has been set, false otherwise.
      */
    public boolean hasWorkflowAdjacencies() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'workflowAdjacencies' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearWorkflowAdjacencies() {
      workflowAdjacencies = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'workflowTags' field.
      * @return The value.
      */
    public java.lang.CharSequence getWorkflowTags() {
      return workflowTags;
    }

    /**
      * Sets the value of the 'workflowTags' field.
      * @param value The value of 'workflowTags'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder setWorkflowTags(java.lang.CharSequence value) {
      validate(fields()[11], value);
      this.workflowTags = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'workflowTags' field has been set.
      * @return True if the 'workflowTags' field has been set, false otherwise.
      */
    public boolean hasWorkflowTags() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'workflowTags' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JobSubmitted.Builder clearWorkflowTags() {
      workflowTags = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JobSubmitted build() {
      try {
        JobSubmitted record = new JobSubmitted();
        record.jobid = fieldSetFlags()[0] ? this.jobid : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.jobName = fieldSetFlags()[1] ? this.jobName : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.userName = fieldSetFlags()[2] ? this.userName : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.submitTime = fieldSetFlags()[3] ? this.submitTime : (java.lang.Long) defaultValue(fields()[3]);
        record.jobConfPath = fieldSetFlags()[4] ? this.jobConfPath : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.acls = fieldSetFlags()[5] ? this.acls : (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) defaultValue(fields()[5]);
        record.jobQueueName = fieldSetFlags()[6] ? this.jobQueueName : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.workflowId = fieldSetFlags()[7] ? this.workflowId : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.workflowName = fieldSetFlags()[8] ? this.workflowName : (java.lang.CharSequence) defaultValue(fields()[8]);
        record.workflowNodeName = fieldSetFlags()[9] ? this.workflowNodeName : (java.lang.CharSequence) defaultValue(fields()[9]);
        record.workflowAdjacencies = fieldSetFlags()[10] ? this.workflowAdjacencies : (java.lang.CharSequence) defaultValue(fields()[10]);
        record.workflowTags = fieldSetFlags()[11] ? this.workflowTags : (java.lang.CharSequence) defaultValue(fields()[11]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<JobSubmitted>
    WRITER$ = (org.apache.avro.io.DatumWriter<JobSubmitted>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<JobSubmitted>
    READER$ = (org.apache.avro.io.DatumReader<JobSubmitted>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
